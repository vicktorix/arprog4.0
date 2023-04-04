package com.argentina.programa;

import java.util.Scanner;

import com.argentina.programa.exceptions.DivideByZeroException;
import com.argentina.programa.exceptions.IndeterminatedException;

public class MenuCalculadora {
    private Scanner mScanner = new Scanner(System.in);
    private Calculadora calculadora = new Calculadora();

    public void ejecutar()
    {
        int opc;
        do
        {
            opc = mostrarOpciones();
            procesar(opc);
            
        }while(opc != 5);
        
    }

    private int mostrarOpciones() {
        System.out.println("************************************");
        System.out.println("\t1 - Sumar");
        System.out.println("\t2 - Restar");
        System.out.println("\t3 - Multiplicar");
        System.out.println("\t4 - Dividir");
        System.out.println("\t5 - Salir");
        System.out.print("Ingrese su elección: ");
        return mScanner.nextInt();
    }

    protected void procesar(int opcion) {
        if (opcion != 5) {
            try{
                switch(opcion)
                {
                    case 1:
                        calculadora.operar(Calculadora.Operacion.SUMAR);
                        break;
                    case 2:
                        calculadora.operar(Calculadora.Operacion.RESTAR);
                        break;
                    case 3:
                        calculadora.operar(Calculadora.Operacion.MULTIPLICAR);
                        break;
                    case 4:
                        calculadora.operar(Calculadora.Operacion.DIVIDIR);
                        break;
                    default:
                        System.out.println("\nOpción no válida");
                        break;
                }
            } catch(IndeterminatedException exception){
                System.err.println(exception.getMessage());
            } catch(DivideByZeroException exception) {
                System.err.println(exception.getMessage());
            }
            
        } else {
            System.out.println("\nGracias por usar la calculadora\n\n");
        }
    }

}
