public class Ejercicio1a {
    public static void main(String[] args) {
        int numeroInicio = 5;
        int numeroFin = 14;
        int i = numeroInicio;
        while (i <= numeroFin) {
            System.out.print(i);
            if (i < numeroFin) {
                System.out.print(",");
            }
            i++;
        }
        System.out.println("");
    }
}