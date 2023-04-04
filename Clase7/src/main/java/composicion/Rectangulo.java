package composicion;

public class Rectangulo {
    private Vector lado1, lado2, lado3, lado4;

    public Rectangulo(Punto p1, Punto p2)
    {
        lado1 = new Vector(p1, new Punto(p1.getX(), p2.getY()));
        lado2 = new Vector(new Punto(p1.getX(), p2.getY()), p2);
        lado3 = new Vector(p2, new Punto(p2.getX(), p1.getY()));
        lado4 = new Vector(new Punto(p2.getX(), p1.getY()), p1);

    }

    public String toString()
    {
        return "Rectángulo con lados: {" + lado1 + ", " + lado2 + ", " + lado3 + ", " + lado4 + "}";

    }

    public double perimetro()
    {
        return lado1.distancia() + lado2.distancia() + lado3.distancia() + lado4.distancia();
    }

    public double area()
    {
        return lado1.distancia() * lado2.distancia();
    }

}
