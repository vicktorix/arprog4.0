package com.argentina.programa;

import java.util.Scanner;

import com.argentina.programa.exceptions.DivideByZeroException;
import com.argentina.programa.exceptions.IndeterminatedException;

public class Calculadora {
    private Scanner mScanner = new Scanner(System.in);
    private double operando1, operando2, resultado;
    private Operacion operacion;

    public enum Operacion{
        SUMAR,
        RESTAR,
        MULTIPLICAR,
        DIVIDIR
    }

    protected double sumar(double operando1, double operando2) {
        return operando1 + operando2;
    }

    protected double restar(double operando1, double operando2) {
        return operando1 - operando2;
    }

    protected double multiplicar(double operando1, double operando2) {
        return operando1 * operando2;
    }

    protected double dividir(double numerador, double denominador) throws IndeterminatedException, DivideByZeroException {
        if (denominador == 0 && numerador == 0) {
            throw new IndeterminatedException();
        } else if (denominador == 0) {
            throw new DivideByZeroException();
        } else {
            return numerador / denominador;
        }
    }

    public void operar(Operacion op) throws IndeterminatedException, DivideByZeroException {
        System.out.print("\nIngrese el primer operando: ");
        operando1 = mScanner.nextDouble();
        System.out.print("\nIngrese el segundo operando: ");
        operando2 = mScanner.nextDouble();
        operacion = op;
        switch(op) {
            case SUMAR:
                resultado = sumar(operando1, operando2);
                break;
            case RESTAR:
                resultado = restar(operando1, operando2);
                break;
            case MULTIPLICAR:
                resultado = multiplicar(operando1, operando2);
                break;
            case DIVIDIR:
                resultado = dividir(operando1, operando2);
                break;
        }
        mostrarResultado();
    }

    private String obtenerStringOperador() {
        switch(operacion) {
            case SUMAR:
                return "+";
            case RESTAR:
                return "-";
            case MULTIPLICAR:
                return "x";
            case DIVIDIR:
                return "/";
            default:
                return "";
        }
    }

    public void mostrarResultado() {
        System.out.println(operando1 + obtenerStringOperador() + operando2 + " = " + resultado );
    }
}
