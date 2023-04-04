package com.argentina.programa.base;

import java.util.Scanner;

public abstract class Menu {

    private static Scanner mScanner = new Scanner (System.in);;

    protected void clearScreen() {
        final String ANSI_CLS = "\u001b[2J";
        final String ANSI_HOME = "\u001b[H";
        System.out.print(ANSI_CLS + ANSI_HOME);
        System.out.flush();
    }

    public static Scanner getScanner(){
        return mScanner;
    }

    protected void pausa(){   
        if (mScanner != null) {
            System.out.println("\nPresione enter para continuar...");
            mScanner.nextLine();
            mScanner.nextLine();
            System.out.println("\n...");
        }   
    }

    public abstract void ejecutar();
    protected abstract int mostrarOpciones();
    protected abstract void procesar(int opcion);
}

