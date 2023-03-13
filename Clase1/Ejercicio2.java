import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        System.out.println("Programa para detectar si pertenece al segemento de Ingresos Altos");

        int MAX_MONTO_MENSUAL = 489083;
        int MAX_AUTOS_NUEVOS = 3;
        int MAX_INMUEBLES = 3;

        int montoMensual = 0, cantVehiculosNuevos = 0, cantInmuebles = 0;
        String activoDeLujo = "";

        Scanner intScanner = new Scanner(System.in);

        System.out.print("Ingrese el monto total mensual de sus ingresos: ");
        montoMensual = intScanner.nextInt();

        System.out.print("Ingrese la cantidad de vehiculo que posee con menos de 5 años de antigüedad: ");
        cantVehiculosNuevos = intScanner.nextInt();

        System.out.print("Ingrese la cantidad de inmuebles que posee: ");
        cantInmuebles = intScanner.nextInt();

        System.out.print("Indique si posee alguna embarcacion, areonave de lujo o activo societario [S]: ");
        activoDeLujo = intScanner.next();

        intScanner.close();

        if (
            montoMensual >= MAX_MONTO_MENSUAL || 
            cantVehiculosNuevos >= MAX_AUTOS_NUEVOS || 
            cantInmuebles >= MAX_INMUEBLES ||
            activoDeLujo.toLowerCase().equals("s")
        ) {
            System.out.println("Usted se encuentra dentro del segmento de altos ingresos");
        } else {
            System.out.println("Usted no se encuentra dentro del segmento de altos ingresos");
        }
    
    }
}
