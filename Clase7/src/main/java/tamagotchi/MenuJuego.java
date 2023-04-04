package tamagotchi;

import java.util.Scanner;

/**
 * Write a description of class MenuJuego here.
 * 
 * @author philip
 * @version (a version number or a date)
 */
public class MenuJuego
{
    private Scanner scnr;
    private MascotaVirtual mascota;
    
    public MenuJuego(MascotaVirtual m)
    {
        mascota = m;
        scnr = new Scanner(System.in);
    }
    
    public void setMascota(MascotaVirtual m)
    {
        mascota = m;
    }
    
    public void ejecutar()
    {
        int opc;
        do
        {
            opc = mostrarOpciones();
            procesar(opc);
            
        }while(opc != 8);
        
    }
    
    private int mostrarOpciones()
    {
        System.out.println("************************************");
        System.out.println("Jugando con: " + mascota.getNombre());
        System.out.println("************************************");
        System.out.println("\t1 - Comer");
        System.out.println("\t2 - Beber");
        System.out.println("\t3 - Correr");
        System.out.println("\t4 - Caminar");
        System.out.println("\t5 - Saltar");
        System.out.println("\t6 - Jugar");
        System.out.println("\t7 - " + ((mascota.isDormido())?"Despertar":"Dormir"));
        System.out.println("\t8 - Volver");
        System.out.print("Ingrese su elección: ");
        return scnr.nextInt();
        
    }
    
    private void procesar(int opc)
    {
        if (opc != 8)
        {
            boolean resAccion = false;
            String accionRealizada = "";
            preAccion();
            switch(opc)
            {
                case 1:
                    resAccion = mascota.comer();
                    accionRealizada = "Comió";
                    break;
                case 2:
                    resAccion = mascota.beber();
                    accionRealizada = "Tomó";
                    break;
                case 3:
                    resAccion = mascota.correr();
                    accionRealizada = "Corrió";
                    break;
                case 4:
                    resAccion = mascota.caminar();
                    accionRealizada = "Caminó";
                    break;
                case 5:
                    resAccion = mascota.saltar();
                    accionRealizada = "Saltó";
                    break;
                case 6:
                    resAccion = mascota.jugar();
                    accionRealizada = "Jugó";
                    break;
                case 7:
                    accionRealizada = (mascota.isDormido())?"Despertó":"Durmió";
                    resAccion = (mascota.isDormido())?mascota.despertar():mascota.dormir();
                    break;
                default:
                    System.out.println("\nElija una opción válida, no sea peregil");
                    break;
            }
            if (opc > 0 && opc < 8) 
                postAccion(resAccion,accionRealizada);
        }
        else
            System.out.println("\nHasta la vista baby\n\n");
    }
    
    public void preAccion()
    {
        
        
    }
    
    public void postAccion(boolean realizoAccion, String accionRealizada)
    {
        if (mascota.isVivo())
        {
            if (realizoAccion)
            {
                System.out.println("Accion realizada: el bicho " + accionRealizada);
                System.out.println("Estado de la mascota:");
                System.out.println("\tEnergía: " + mascota.getEnergia());
                System.out.println("\tEl bicho está " + mascota.getHumor());
                System.out.println("\tEl bicho está " + ((mascota.isDormido())?"dormido":"despierto"));
                System.out.println();
            }
            else
            {
                System.out.println("No se pudo realizar la acción...");
                System.out.println("\tdebido a: " + mascota.getMotivoInaccion());
            }
            
        }
        else
        {
            System.out.println("Lamentablemente la mascota ha abandonado esta dimensión...");
            System.out.println("\t a razón de: " + mascota.getMotivoMuerte());
        }
        
        System.out.println("\nPresione enter para continuar...\n\n\n");
        scnr.nextLine();
    }
}
