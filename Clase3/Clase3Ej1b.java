package Clase4.Ejercicios;

public class Clase3Ej1b {
    public static void main(String[] args) {
        int[] vector3 = { 1, -3, 1 };
        int[] vectorResultante = new int[3];

        System.out.println("Vector original");
        mostrarVector(vector3);

        System.out.println("Vector ordenado de manera descendente");
        vectorResultante = ordenarVector(vector3, DESCENDENTE);
        mostrarVector(vectorResultante);

        System.out.println("Vector ordenado de manera ascendente");
        vectorResultante = ordenarVector(vector3, ASCENDENTE);
        mostrarVector(vectorResultante);
    }

    // Ordena un vector por el método de insersión
    public static int[] ordenarVector(int[] vector, boolean orden) {
        int tempValue = 0, tempPos = 0;

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

    public static void mostrarVector(int[] vector) {
        System.out.print("[");
        for (int i = 0; i < vector.length; i++) {
            System.out.print(String.format("%d", vector[i]));
            if (i < vector.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public static boolean ASCENDENTE = false;
    public static boolean DESCENDENTE = true;

}
