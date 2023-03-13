public class Ejercicio1c {
    public static void main(String[] args) {
        int numeroInicio = 5;
        int numeroFin = 14;
        int i = numeroInicio;
        int tipo = Paridad.TODOS;
        while (i <= numeroFin) {
            if (i%2 == 0 && (tipo == Paridad.PAR || tipo == Paridad.TODOS)) {
                System.out.print(i);
                if (i < numeroFin) {
                    System.out.print(",");
                }
            } else if(i%2 != 0 && (tipo == Paridad.IMPAR || tipo == Paridad.TODOS)) {
                System.out.print(i);
                if (i < numeroFin) {
                    System.out.print(",");
                }
            }
            i++;
        }
        System.out.println("");
    }

    public static class Paridad {
        public final static int PAR = 0;
        public final static int IMPAR = 1;
        public final static int TODOS = 2; 
    }
}