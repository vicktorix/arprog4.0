package com.argentina.programa.tomagochi;

import java.util.Scanner;

import com.argentina.programa.base.Menu;

public class MenuJuego extends Menu{
    private Mascota mMascota;

    public MenuJuego(Mascota mascota){
        mMascota = mascota;
    }

    public void setMascota(Mascota mascota){
        mMascota = mascota;
    }

    @Override
    public void ejecutar()
    {
        int opc;
        do
        {
            opc = mostrarOpciones();
            procesar(opc);
            
        }while(opc != 6);
        
    }

    @Override
    protected int mostrarOpciones() {
        clearScreen();
        System.out.println("************************************");
        System.out.println("Jugando con: " + mMascota.getNombre());
        System.out.println("Energia: " + mMascota.getEnergia());
        System.out.println("Humor: " + mMascota.getHumor());
        if (!mMascota.estaVivo()) {
            System.out.println("La mascota está muerta, game over");
        }
        System.out.println("************************************");
        System.out.println("\t1 - Comer \t +10% enenrgia  +1 humor");
        System.out.println("\t2 - Beber \t +5% energia  +1 humor");
        System.out.println("\t3 - Correr \t -35% energia  -2 humor");
        System.out.println("\t4 - Saltar \t -15% energia  -2 humor");
        System.out.println("\t5 - " + ((mMascota.getEstaDormido())?"Despertar":"Dormir \t +25u energia  +2 humor"));
        System.out.println("\t6 - Volver");
        System.out.print("Ingrese su elección: ");
        return Menu.getScanner().nextInt();
    }

    @Override
    protected void procesar(int opcion) {
        if (opcion != 6)
        {
            boolean resAccion = false;
            String accionRealizada = "";
            clearScreen();
            switch(opcion)
            {
                case 1:
                    resAccion = mMascota.comer();
                    accionRealizada = "Comió";
                    break;
                case 2:
                    resAccion = mMascota.beber();
                    accionRealizada = "Tomó";
                    break;
                case 3:
                    resAccion = mMascota.correr();
                    accionRealizada = "Corrió";
                    break;
                case 4:
                    resAccion = mMascota.saltar();
                    accionRealizada = "Saltó";
                    break;
                case 5:
                    accionRealizada = (mMascota.getEstaDormido())?"Despertó":"Durmió";
                    resAccion = (mMascota.getEstaDormido())?mMascota.despertar():mMascota.aDormir();
                    break;
                default:
                    System.out.println("\nElija una opción válida, no sea peregil");
                    break;
            }
            if (opcion > 0 && opcion < 6) 
                postAccion(resAccion,accionRealizada);
        } else {
            System.out.println("\nHasta la vista baby\n\n");
        }
    }

    public void postAccion(boolean realizoAccion, String accionRealizada)
    {
        if (mMascota.estaVivo())
        {
            if (realizoAccion)
            {
                System.out.println("Accion realizada: el bicho " + accionRealizada);
                System.out.println("Estado de la mascota:");
                System.out.println("\tEnergía: " + mMascota.getEnergia());
                System.out.println("\tEl bicho está " + mMascota.getHumor());
                System.out.println("\tHumor :" + mMascota.getHumorCantidad());
                System.out.println("\tEl bicho está " + ((mMascota.getEstaDormido())?"dormido":"despierto"));
                System.out.println();
            }
            else
            {
                System.out.println("No se pudo realizar la acción...");
                System.out.println("\tdebido a: " + mMascota.getMotivoInaccion());
            }
            
        }
        else
        {
            System.out.println("\tEnergía: " + mMascota.getEnergia());
            System.out.println("\tEl bicho está " + mMascota.getHumor());
            System.out.println("\tHumor :" + mMascota.getHumorCantidad());
            System.out.println("Lamentablemente la mascota ha abandonado esta dimensión...");
            System.out.println("\t a razón de: " + mMascota.getMotivoMuerte());
        }

        System.out.println("\nPresione enter para continuar...\n\n\n");
        Menu.getScanner().nextLine();
        Menu.getScanner().nextLine();
    }
}
