package com.argentina.programa.models;

/**
 *
 * @author philip
 */
public class Vector
{
    //Atributos
    private Punto puntoOrigen;
    private Punto puntoFinal;
    
    //Constructores
    public Vector(Punto origen, Punto destino)
    {
        puntoOrigen = origen;
        puntoFinal = destino;
    }
    
    
    /**
     * Este constructor construye un vector desde el inicio al destino indicado en el parámetro @param destino 
     * @param destino punto final del vector con inicio en el origen
     */
    public Vector(Punto destino)
    {
        this(new Punto(0,0), destino);
    }
    
    public Vector(double xi, double yi, double xf, double yf)
    {
        this(new Punto(xi, yi), new Punto(xf, yf));
    }
    
    //Métodos
    public String toString()
    {
        String s = "[" + puntoOrigen + "," + puntoFinal + "]";
        return s;
    }
    
    public double distancia()
    {
        double base, altura;
        
        base = Math.abs(puntoFinal.getX()) - Math.abs(puntoOrigen.getX());
        altura = Math.abs(puntoFinal.getY()) - Math.abs(puntoOrigen.getY());
        
        double distancia = Math.sqrt(base * base + altura * altura);
        
        return distancia;
        
    }
    
    public Punto getPuntoOrigen()
    {
        return puntoOrigen;
    }
    
    public Punto getPuntoFinal()
    {
        return puntoFinal;
    }
    
    public boolean paraleloEjeX()
    {
        return puntoOrigen.getY() == puntoFinal.getY();
    }

    public boolean paraleloEjeY()
    {
        return puntoOrigen.getX() == puntoFinal.getX();
    }
    
    public boolean estaEjeX()
    {
    	return this.paraleloEjeX() && puntoOrigen.estaEjeX();
    }
}
