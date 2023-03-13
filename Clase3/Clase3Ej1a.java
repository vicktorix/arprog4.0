package Clase4.Ejercicios;

import java.util.Scanner;

public class Clase3Ej1a {
    public static void main(String[] args) {
        System.out.println(
                "Programa que pide una cadena de texto y un caracter y cuenta las ocurrencias de este último.");

        String text = "";
        char c;
        int veces = 0;
        Scanner mScanner = new Scanner(System.in);

        System.out.println("Ingrese un texto: ");
        text = mScanner.nextLine();

        System.out.print("Ingrese un caracter a buscar: ");
        c = mScanner.next().charAt(0);

        System.out.println("");
        veces = contarOcurrencias(text, c);

        String vecesText = "";
        if (veces != 1) {
            vecesText = "veces";
        } else {
            vecesText = "vez";
        }
        System.out.println(
                String.format(
                        "La cantidad de veces que '%c' se encuentra en el texto es %d %s",
                        c,
                        veces,
                        vecesText));
    }

    public static int contarOcurrencias(String s, char c) {
        int ocurrencias = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                ocurrencias++;
            }
        }
        return ocurrencias;
    }
}
