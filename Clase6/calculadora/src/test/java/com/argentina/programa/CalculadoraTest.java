package com.argentina.programa;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.argentina.programa.exceptions.DivideByZeroException;
import com.argentina.programa.exceptions.IndeterminatedException;

public class CalculadoraTest {

    private Calculadora calculadora = new Calculadora();
    @Before
    public void init(){
        
    }

    @Test
    public void siMultiplicar80Por3EntoncesDa240(){
        // Dado
        
        double resultado = calculadora.multiplicar(80, 3);
        
        // Entonces
        assertEquals(240, resultado, 0.1f);
    }

    @Test
    public void si150Mas180Divido3EntoncesDa110(){
        // Dado
        calculadora = new Calculadora();
        double resultado = calculadora.sumar(150, 180);
        
        try {
            resultado = calculadora.dividir(resultado, 3);
        } catch (IndeterminatedException e) {
            assert(false);
            e.printStackTrace();
        } catch (DivideByZeroException e) {
            assert(false);
            e.printStackTrace();
        }

        // Entonces
        assertEquals(110, resultado, 0.1f);
    }

    @Test
    public void si90Menos50Por15EntoncesDa600(){
        // Dado
        calculadora = new Calculadora();
        double resultado = calculadora.restar(90, 50);
        resultado = calculadora.multiplicar(resultado, 15);

        // Entonces
        assertEquals(600, resultado, 0.1f);
    }

    @Test
    public void si70Mas40Por25EntoncesDa2700(){
        // Dado
        calculadora = new Calculadora();
        double resultado = calculadora.sumar(70, 40);
        resultado = calculadora.multiplicar(resultado, 25);

        // Entonces
        assertEquals(2750, resultado, 0.1f);
    }

}
