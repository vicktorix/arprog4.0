package tamagotchi;

/**
 * Esta clase sirve para crear instancias que representan a una mascota virtual del juego del
 * tamagotchi.
 * 
 * @author philip
 * @version hoy
 */
public class MascotaVirtual
{
    //Atributos
    /**
     * Nombre de la mascota
     */
    private String nombre;
    /**
     * Energía de la mascota
     */
    private int energia;
    /**
     * Grado de humor de la mascota
     */
    private int humor;
    
    private int contIngesta;
    private int contActividad;
    private boolean vivo;
    private boolean dormido;
    private String motivoMuerte;
    private String motivoInaccion;
    
    public static String[] HUMORES = new String[] {"Furioso", "Enojado", "Neutral", "Contento", "Chocho"};
    
    public MascotaVirtual(String nom)
    {
        nombre = nom;
        setEnergia(75);
        setHumor(3);
        
        vivo = true;
        dormido = false;
        
        contIngesta = contActividad = 0;
        
    }
    
    public int getEnergia()
    {
        return energia;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public String getMotivoMuerte()
    {
        return motivoMuerte;
    }
    
    public boolean isVivo()
    {
        return vivo;
    }
    
    public String getHumor()
    {
        return HUMORES[humor - 1];
    }
    
    public boolean isDormido()
    {
        return dormido;
    }
    
    public String getMotivoInaccion()
    {
        return motivoInaccion;
    }
    
    private void setEnergia(int e)
    {
        if (e <= 0)
        {
            energia = 0;
            vivo = false;
            motivoMuerte = "Se agotó su espíritu...";
        }
        else if (e > 100)
            energia = 100;
        else
            energia = e;
        
    }
    
    private void setHumor(int h)
    {
        if (h < 1)
            humor = 1;
        else if (h > 5)
            humor = 5;
        else
            humor = h;
        
    }
    
    public boolean despertar()
    {
        boolean resp = false;
        if (controlarVida() && dormido)
        {
            dormido = false;
            resp = true;
        }
        else
           if (isVivo())
                motivoInaccion = "Ya estaba despierto...";
        return resp;
    }
    
    public boolean controlarVida()
    {
        if (!isVivo())
            motivoInaccion = "Esta muerto";
        else
            motivoInaccion = "";
        return isVivo();
    }
    
    public boolean dormir()
    {
         boolean resp = false;
        if (controlarVida() && !dormido)
        {
            contIngesta = 0;
            contActividad = 0;
            setEnergia((int)(energia * 1.2));
            setHumor(humor - 2); 
            dormido = true;
            resp = true;
        }
        else
           if (isVivo())
                motivoInaccion = "Ya estaba dormido...";
        return resp;
        
    }
    
    public boolean controlarDespierto()
    {
        boolean resp = controlarVida();
        if (resp && dormido)
        {
            motivoInaccion = "Esta dormido...";
            resp = false;
        }
        return resp;
    }
    
    public boolean comer()
    {
        boolean resp = false;
        if (controlarDespierto())
        {
            setEnergia((int)(energia * 1.15));
            //TODO:  revisar en base a la variabilidad
            setHumor(humor + 1);
            
            contIngesta++;
            contActividad = 0;
            
            if (contIngesta >= 5)
            {
                vivo = false;
                motivoMuerte = "Indigestión...";
            }
            
            resp = true;
        }
        return resp;
        
    }

    public boolean beber()
    {
        boolean resp = false;
        if (controlarDespierto())
        {
            setEnergia((int)(energia * 1.10));
            //TODO:  revisar en base a la variabilidad
            setHumor(humor + 2);
            
            contIngesta++;
            contActividad = 0;
            
            if (contIngesta >= 5)
            {
                vivo = false;
                motivoMuerte = "Murió ahogado...";
            }
            
            resp = true;
        }
        return resp;
        
    }
    
    public boolean correr()
    {
        boolean resp = false;
        if (controlarDespierto())
        {
            setEnergia(energia - 15);
            setHumor(humor + 1);
            
            contIngesta = 0;
            contActividad++;
            
            controlarActividades();
            
            resp = true;
        }
        return resp;
                
    }
    
    public boolean caminar()
    {
        boolean resp = false;
        if (controlarDespierto())
        {
            setEnergia(energia - 5);
            
            contIngesta = 0;
            contActividad++;
            
            controlarActividades();
            
            resp = true;
        }
        return resp;
    }
    
    public boolean saltar()
    {
        boolean resp = false;
        if (controlarDespierto())
        {
            setEnergia(energia - 20);
            setHumor(humor + 1);
            
            contIngesta = 0;
            contActividad++;
            
            controlarActividades();
            
            resp = true;
        }
        return resp;
    }

    public boolean jugar()
    {
        boolean resp = false;
        if (controlarDespierto())
        {
            setEnergia(energia - 30);
            if (humor >= 2)
            {
                setHumor(humor + 1);
            }
            else
            {
                setHumor(humor + 3);
            }
            
            contIngesta = 0;
            contActividad++;
            
            controlarActividades();
            
            resp = true;
        }
        return resp;
    }
    
    private void controlarActividades()
    {
        if (contActividad >= 5)
        {
            dormir();
        }
    }
}
