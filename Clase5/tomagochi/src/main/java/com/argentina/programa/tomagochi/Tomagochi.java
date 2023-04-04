package com.argentina.programa.tomagochi;

import java.util.Scanner;
import com.argentina.programa.base.Menu;

public class Tomagochi extends Menu{
    private Mascota mascota;
    private MenuJuego menuJuego;
    public Tomagochi() {
        mascota = null;
        menuJuego = null;
    }

    @Override
    public void ejecutar() {
        int opc;
        do {
            opc = mostrarOpciones();
            procesar(opc);
        } while (opc != 4);
    }

    @Override
    protected int mostrarOpciones() {
        clearScreen();
        System.out.println("************************************");
        System.out.println("* Super Tamagotchi !!!!!           *");
        System.out.println("************************************");
        System.out.println("\t1 - Crear Mascota");
        System.out.println("\t2 - Reiniciar Mascota");
        System.out.println("\t3 - Jugar");
        System.out.println("\t4 - Salir");
        System.out.print("Ingrese su elección: ");
        return Menu.getScanner().nextInt();
    }

    @Override
    protected void procesar(int opcion) {
        switch(opcion){
            case 1:
                if (mascota == null) {
                    crearMascota();
                } else {
                    System.out.println("Ya existe una mascota creada");
                }
                pausa();
                break;
            case 2:
                if (mascota == null) {
                    System.out.println("No existe aún una mascota creada");
                } else {
                    reiniciarMascota();
                }
                pausa();
                break;
            case 3:
                if (mascota != null) {
                    irAJugar();
                } else {
                    System.out.println("Debe crear una mascota antes de empezar a jugar");
                }
                pausa();
                break;
            case 4:
                System.out.println("Gracias por jugar con Super Tomagochi");
                pausa();
                break;
            default:
                System.out.println("No joda che, esa no es una opción válida");
        }
    }

    private void crearMascota(){
        String nombre;
        System.out.print("Ingrese el nombre para el bicho: ");
        nombre = Menu.getScanner().next();
        mascota = new Mascota();
        mascota.initialize(nombre);
        System.out.println("\nMascota Creada!!!");
    }

    private void reiniciarMascota(){
        mascota.initialize();
    }

    private void irAJugar(){
        if (menuJuego == null) {
            menuJuego = new MenuJuego(mascota);
        } else {
            menuJuego.setMascota(mascota);
        }
        menuJuego.ejecutar();
    }

}
