package tamagotchi;

import java.util.Scanner;

/**
 * Write a description of class MenuPrincipal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuPrincipal
{
    private MascotaVirtual mascota;
    private MenuJuego menuJuego;
    private Scanner scnr;
    
    public MenuPrincipal()
    {
        mascota = null;
        menuJuego = null;
        scnr = new Scanner(System.in);
    }
    
    public void ejecutar()
    {
        int opc;
        do
        {
            opc = mostrarOpciones();
            procesar(opc);
            
        }while(opc != 4);
        
    }
    
    private int mostrarOpciones()
    {
        System.out.println("************************************");
        System.out.println("* Super Tamagotchi !!!!!           *");
        System.out.println("************************************");
        System.out.println("\t1 - Crear Bicho");
        System.out.println("\t2 - Crear y Pisar Bicho");
        System.out.println("\t3 - Jugar");
        System.out.println("\t4 - Salir");
        System.out.print("Ingrese su elección: ");
        return scnr.nextInt();
        
    }
    
    private void procesar(int opc)
    {

        switch(opc)
        {
            case 1:
                if (mascota == null)
                    crearMascota();
                else
                    System.out.println("Error:  ya existe un bicho creado");
                pausa();
                break;
            case 2:
                crearMascota();
                pausa();
                break;
            case 3:
                if (mascota != null)
                {
                    if (menuJuego == null)
                        menuJuego = new MenuJuego(mascota);
                    else
                        menuJuego.setMascota(mascota);
                    menuJuego.ejecutar();    
                }
                else
                {
                    System.out.println("No hay un bicho creado, debe crearlo primero...");
                }
                pausa();
                break;
            case 4:
                System.out.println("Gracias por jugar con TAMAGOTCHI!!!");
                pausa();
                break;
            default:
                System.out.println("No sea peregil");
                
        }
        
    }
    
    public void crearMascota()
    {
        String nombre;
        System.out.print("Ingrese el nombre para el bicho: ");
        nombre = scnr.next();
        mascota = new MascotaVirtual(nombre);
        System.out.println("\nMascota Creada!!!");
        
    }
    
    public void pausa()
    {
        System.out.println("\nPresione enter para continuar...");
        scnr.nextLine();
        
    }
}
