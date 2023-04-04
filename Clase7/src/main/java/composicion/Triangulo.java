package composicion;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 ;

/**
 *
 * @author Felipe
 */
public class Triangulo
{
    //Atributos
    private Vector lado1;
    private Vector lado2;
    private Vector lado3;
    
    //Constructor
    public Triangulo(Punto p1, Punto p2, Punto p3)
    {
        lado1 = new Vector(p1, p2);
        lado2 = new Vector(p2, p3);
        lado3 = new Vector(p3, p1);
        
    }

    public String toString()
    {
        return "Tirángulo con lados: {" + lado1 + ", " + lado2 + ", " + lado3 + "}";
        
    }
    
    public double perimetro()
    {
        return lado1.distancia() + lado2.distancia() + lado3.distancia();
    }
    
    public double area()
    {
        double s = perimetro() / 2;
        
        double area = Math.sqrt(s*(s - lado1.distancia()) * 
                                    (s - lado2.distancia()) * 
                                    (s - lado3.distancia()));
        
        return area;
    }
}
