package ej4.dos;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Programa que lee números de un archivo y los suma\n" +
                "Uso: java App.class archivo\n");

        if (args.length > 0) {
            switch (args.length) {
                case 1:
                    initOper(args[0]);
                    break;
                default:
                    initOper(args[0], args[1]);
                    break;
            }
        } else {
            System.out.println("No se indicó ningún archivo");
        }
    }

    private static void initOper(String filename) {
        initOper(filename, "S");
    }

    private static void initOper(String filename, String operation) {
        float acumulador = 0f;
        String sumaString = "La suma ", prodcutoString = "El producto ";
        if (operation.equals("S") || operation.equals("M")) {
            acumulador = operarNumeros(filename, operation);
        } else {
            acumulador = operarNumeros(filename, "S");
        }
        mostrarResultado(acumulador, operation);
    }

    private static void mostrarResultado(float resultado, String operation) {
        String sumaString = "La suma ", prodcutoString = "El producto ";
        if(operation.equals("S")) {
            System.out.println(sumaString + "de los números es: " + resultado);
        } else {
            System.out.println(prodcutoString + "de los números es: " + resultado);
        }
    }

    public static float operarNumeros(String filename, String oper) {
        float acumulador = 0f;
        Path f = Paths.get(filename);

        System.out.println(f.toString());
        if (oper.equals("M")) {
            acumulador = 1;
        }

        if (Files.exists(f) & Files.isReadable(f)) {
            try {
                Scanner miEscaner = new Scanner(f);
                while (miEscaner.hasNextLine()) {
                    String sNum = miEscaner.nextLine();
                    try {
                        if (oper.equals("S")) {
                            acumulador += Float.parseFloat(sNum);
                        } else {
                            acumulador *= Float.parseFloat(sNum);
                        }

                    } catch (Exception e) {
                        // no-op
                    }
                }
            } catch (Exception e) {
                System.out.println("Error al acceder al archivo " + f.toAbsolutePath().toString());
            }
        } else {
            System.out.println("El archivo " + f.toAbsolutePath().toString() + " no existe");
        }

        return acumulador;
    }

}
