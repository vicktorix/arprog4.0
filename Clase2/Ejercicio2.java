package Clase3.Ejercicios;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
    
        int[] divisores = {2,3,5,7};
        int numero = 0;

        int cont = 0;

        boolean esPrimo = false;

        Scanner in = new Scanner(System.in);

        System.out.print("Ingrese un número entero entre el 1 y el 120: ");

        try {
            numero = in.nextInt();
            if (numero > 0 && numero < 121) {

                if (numero > 7) {
                    esPrimo = true;
                } 
    
                for (int i = 0; i < divisores.length; i++) {
                        if (numero > 7 && numero % divisores[i] == 0) {
                            esPrimo = false;
                            break;
                        } else {
                            if(numero == divisores[i] || numero == 1) {
                                esPrimo = true;
                            } 
                        }
                }
                
                if (esPrimo) {
                    System.out.println("El número " + numero + " es primo");
                } else {
                    System.out.println("El número " + numero + " no es primo");
                }

            } else {
                System.out.println("El número " + numero + " está fuera del rango de 1 a 120");
            }

        } catch(Exception e) {
            System.out.println("El dato ingresado no es un número entero entre 1 y 120");
        };
    }
}
