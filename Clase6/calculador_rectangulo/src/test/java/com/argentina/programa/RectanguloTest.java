package com.argentina.programa;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.argentina.programa.models.Punto;
import com.argentina.programa.models.Rectangulo;

public class RectanguloTest {
    private Punto p1, p2;
    
    @Before
    public void init(){
        p1 = new Punto(1.0, 1.0);
        p2 = new Punto(4.0, 4.0);
    }

    @Test
    public void probarRectangulo(){
        Rectangulo rect = new Rectangulo(p1, p2);
        double perimetro = rect.perimetro();
        double area = rect.area();
        double expectedPerimetro = 12.0;
        double expectedArea = 9.0;
        double tolerance = 0.001;

        assertEquals(expectedPerimetro, perimetro, tolerance);
        assertEquals(expectedArea, area, tolerance);
    }
}
