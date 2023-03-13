package Clase4.Ejercicios;

import java.util.Scanner;

public class Clase3Ej2 {
    public static void main(String[] args) {
        Scanner mScanner = new Scanner(System.in);
        String texto = "", textoCod= "";
        int desplazamiento = 0;


        System.out.println("Ingrese un texo para codificar");
        texto = mScanner.nextLine();

        System.out.print("Ingrese el desplazamiento para codificar el texto: ");
        desplazamiento = mScanner.nextInt();

        textoCod = codificarTexto(texto, desplazamiento);

        System.out.println("\n\nTexto Original");
        System.out.println(texto);

        System.out.println("\n\nTexto Codificado");
        System.out.println(textoCod);
    }

    private static String codificarTexto(String texto, int desplazamiento) {
        String result = "";
        for(int i = 0; i < texto.length(); i++) {
            char temp = (char)(texto.charAt(i) + desplazamiento);
            result += String.valueOf(temp);
        }
        return result;
    }
}
