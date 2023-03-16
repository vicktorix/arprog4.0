package ej4.dos;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{   
    public static void main( String[] args )
    {
        System.out.println( "Programa que lee números de un archivo y los suma\n" +
        "Uso: java App.class archivo\n" );
        
        if (args.length > 0) {
            float suma = sumarNumeros(args);
            System.out.println("La suma de los números es: " + suma);
        } else {
            System.out.println("No se indicó ningún archivo");
        }
    }

    public static float sumarNumeros(String[] args) {
        float suma = 0f;
        Path f = Paths.get(args[0]);

        System.out.println(f.toString());

        if (Files.exists(f) & Files.isReadable(f)) {
            try {
                Scanner miEscaner = new Scanner(f);
                while(miEscaner.hasNextLine()){
                    String sNum = miEscaner.nextLine();
                    try {
                        suma += Float.parseFloat(sNum);
                    } catch (Exception e) {
                        //no-op
                    }
                }
            } catch (Exception e) {
                System.out.println("Error al acceder al archivo " + f.toAbsolutePath().toString());
            }
        } else {
            System.out.println("El archivo " + f.toAbsolutePath().toString() + " no existe");  
        }
        
        return suma;
    }

}
