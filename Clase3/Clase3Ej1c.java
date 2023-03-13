package Clase4.Ejercicios;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Clase3Ej1c {
    public static void main(String[] args) throws InputMismatchException {
        int[] vector = new int[1000];
        int limite = 0, suma = 0;
        Scanner sc = new Scanner(System.in);
        llenarVectorAleatoriamente(vector);
        System.out.print("Programa que suma los número de un vector mayores a un limite X\n\n");


        System.out.print("Ingrese un número del 0 al 99 como límite de la suma: ");
        limite = sc.nextInt();
        System.out.println("");

        if (limite < 0 || limite > 99) {
            System.out.println("El número límite debe ser entre 0 y 99 ");
        } else {
            mostrarVector(vector, limite);
            suma = sumaConLimite(vector, limite);
            System.out.println(String.format("\n La suma de los elementos mayores que %d es %d", limite, suma));
        }
    }


    private static int sumaConLimite(int[] vector, int limite) {
        int suma = 0;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] > limite) {
                suma += vector[i];
            }
        }
        return suma; 
    }

    private static void llenarVectorAleatoriamente(int[] vector) {
        Random rand = new Random();
        for (int i = 0; i < vector.length; i++) {
            vector[i] = rand.nextInt(100);        }
    }

    public static void mostrarVector(int[] vector, int limite) {
        String color = ANSI_WHITE_BACKGROUND;
        System.out.print(color + "[");
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] > limite) {
                color = ANSI_RED_BACKGROUND;
            } else {
                color = ANSI_WHITE_BACKGROUND;
            }
            System.out.print(String.format("%s%3d", color, vector[i]));
            
            if (i < vector.length - 1) {
                System.out.print(",");
            }
            if (i%30 == 0 && i > 0) {
                color = ANSI_BLACK_BACKGROUND;
                System.out.println(color);
            }
        }
        System.out.print("]");
        color = ANSI_BLACK_BACKGROUND; 
        System.out.println(color);
    }

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
}
