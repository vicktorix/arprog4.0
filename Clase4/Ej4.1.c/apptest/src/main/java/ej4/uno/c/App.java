package ej4.uno.c;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    private static String error2 = "Debe ingresar A para ascendente o D para descendente";
    private static String error3 = "Debe ingresar número enteros o flotantes. Por ej. 7, o 7.01";

    public static boolean ASCENDENTE = true;
    public static boolean DESCENDENTE = false;

    public static void showError(String error) {
        System.err.println(error);
    }

    public static void main(String[] args) {
        float[] numeros = new float[3];
        boolean orden = ASCENDENTE;

        try {
            numeros = ingresarNumeros(args);
            orden = ingresarOrden(args);

            numeros = ordenarVector(numeros, orden);
            mostrarVector(numeros);

        } catch (Exception e) {
            showError(e.getMessage());
        }
    }

    public static float[] ingresarNumeros(String[] args) throws Exception {
        int cant = 3;
        String[] ordinalString = { "primer", "segundo", "tercer" };
        float[] nums = new float[cant];
        Scanner mScanner = new Scanner(System.in);
        if (args.length > cant) {
            cant = 3;
        } else {
            cant = args.length;
        }

        if (cant > 0) {
            for (int i = 0; i < cant; i++) {
                if (isANumber(args[i])) {
                    nums[i] = Float.parseFloat(args[i]);
                } else {
                    System.out.println("num break;");
                    cant = i;
                    break;
                }
            }
        }

        try {
            for (int i = cant; i < 3; i++) {
                System.out.print("Ingrese el " + ordinalString[i] + " número: ");
                nums[i] = mScanner.nextFloat();
            }
        } catch (Exception e) {
            throw new Exception(error3);
        }
        ;

        return nums;
    }

    public static boolean isANumber(String s) {
        try {
            Float.parseFloat(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean ingresarOrden(String[] args) throws Exception {
        String sOrd = "";
        Scanner mScanner = new Scanner(System.in);

        if (args.length > 0) {
            int cant = args.length > 3 ? 3 : args.length;
            for (int i = 0; i < cant; i++) {
                if (args[i].equals("A") || args[i].equals("D")) {
                    sOrd = args[i];
                    break;
                }
            }
        }

        if (sOrd.isBlank()) {
            try {
                System.out.print("Ingrese el orden de los números ascendente o descendente [A|D]: ");
                sOrd = mScanner.nextLine();

                if (!(sOrd.equals("A") || sOrd.equals("D"))) {
                    throw new Exception(error2);
                }
            } catch (Exception e) {
                throw new Exception(error2);
            }
            ;
        }

        return sOrd.equals("A");
    }

    public static void mostrarVector(float[] vector) {
        System.out.print("[");
        for (int i = 0; i < vector.length; i++) {
            System.out.print(String.format("%s", vector[i]));
            if (i < vector.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    // Ordena un vector por el método de insersión
    public static float[] ordenarVector(float[] vector, boolean orden) {
        float tempValue = 0;
        int tempPos = 0;

        for (int i = 0; i < vector.length; i++) {
            tempValue = vector[i];
            tempPos = i;

            while (tempPos > 0 &&
                    ((vector[tempPos - 1] > tempValue && orden) ||
                            (vector[tempPos - 1] < tempValue && !orden))) {
                vector[tempPos] = vector[tempPos - 1];
                tempPos -= 1;
            }
            vector[tempPos] = tempValue;
        }

        return vector;
    }
}
