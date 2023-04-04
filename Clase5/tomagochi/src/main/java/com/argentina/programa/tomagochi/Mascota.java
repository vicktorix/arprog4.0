package com.argentina.programa.tomagochi;

public class Mascota {
    private String nombre;
    private int energia, humorCantidad;
    private final int MAX_ENERGIA = 100;
    private final int MAX_HUMOR = 5;
    private final float COMER_ENERGIA = 10;
    private final float BEBER_ENERGIA = 5;
    private final float CORRER_ENERGIA = 35;
    private final float SALTAR_ENERGIA = 15;
    private final int ENERGIA_DORMIR = 25;
    private final int INGESTA_HUMOR = 1;
    private final int ACTIVIDAD_HUMOR = 2;
    private int vida = 0;
    private boolean estaDormido;
    private int cantidadIngestasConsecutivas, cantidadActividadesConsecutivas;

    public enum Humor {
        ME_FUI_A_DORMIR,
        MUY_ENOJADO,
        ENOJADO,
        NEUTRAL,
        CONTENTO,
        CHOCHO
    }

    public enum MotivoInaccion {
        MUERTO,
        DORMIDO
    }

    public void initialize(String nombreMascota) 
    {
        nombre = nombreMascota;
        initialize();
        vida = 1;
    }

    public void initialize() {
        vida++;
        setEnergia(MAX_ENERGIA);
        setHumorCantidad(MAX_HUMOR);
        estaDormido = false;
        cantidadIngestasConsecutivas = 0;
        cantidadActividadesConsecutivas = 0;
    }

    public int getVida() {
        return vida;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEnergia() {
        return energia;
    }

    public int getHumorCantidad() {
        return humorCantidad;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public void setHumorCantidad(int humor) {
        this.humorCantidad = humor;
    }
    public boolean getEstaDormido() {
        return estaDormido;
    }

    public Humor getHumor() {
        switch(humorCantidad) {
            case 5:
                return Humor.CHOCHO;
            case 4:
                return Humor.CONTENTO;
            case 3:
                return Humor.NEUTRAL;
            case 2:
                return Humor.ENOJADO;
            case 1:
                return Humor.MUY_ENOJADO;
            default:
                return Humor.ME_FUI_A_DORMIR;
        }
    }

    public boolean comer() {
        if (actividadDisponible()) {
            ingesta(COMER_ENERGIA);
            return true;
        } else {
            return false;
        }
    }

    public boolean beber() {
        if (actividadDisponible()) {
            ingesta(BEBER_ENERGIA);
            return true;
        } else {
            return false;
        }
    }

    public boolean correr() {
        if (actividadDisponible()) {
            actividad(CORRER_ENERGIA);
            return true;
        } else {
            return false;
        }
    }

    public boolean saltar() {
        if (actividadDisponible()) {
            actividad(SALTAR_ENERGIA);
            return true;
        } else {
            return false;
        }
    }

    public boolean aDormir() {
        if(!estaDormido && estaVivo()) {
            estaDormido = true;
            int humorCantidadTemp = humorCantidad + ACTIVIDAD_HUMOR;
            humorCantidad = humorCantidadTemp > 5 ? MAX_HUMOR : humorCantidadTemp;
            int tempEnergia = energia + ENERGIA_DORMIR;
            energia = tempEnergia > MAX_ENERGIA ? MAX_ENERGIA : tempEnergia;
            return true;
        } else {
            return false;
        }
    }

    public boolean despertar() {
        if(estaDormido && estaVivo()) {
            estaDormido = false;
            return true;
        } else {
            return false;
        }
    }

    public String getMotivoInaccion() {
        if (estaDormido) {
            return "La mascota está dormida";
        } else if (!estaVivo()) {
            return "La mascoca ha muerto";
        } else {
            return "Se desconoce la razón";
        }
    }

    public String getMotivoMuerte() {
        if (cantidadIngestasConsecutivas >= 5) {
            return "La mascota murió por empacho";
        } else if (energia <= 0) {
            return "La mascota murió por innanición";
        } else {
            return "Se desconoce la razón de la muerte";
        }
    }

    public boolean estaVivo() {
        return energia > 0;
    }

    private boolean actividadDisponible(){
        return !estaDormido && estaVivo();
    }
    
    private void actividad(float porcentajeEnergia) {
        cantidadIngestasConsecutivas = 0;
        int tempEnergia = (int) (energia * (1 - porcentajeEnergia / 100));
        int tempHumor = humorCantidad - ACTIVIDAD_HUMOR;
        energia = tempEnergia > 0 ? tempEnergia : 0;
        humorCantidad = tempHumor > 0 ? tempHumor : 0;
        cantidadActividadesConsecutivas++;
        if (cantidadActividadesConsecutivas > 3 || humorCantidad == 0) {
            aDormir();
        }
    }

    private void ingesta(float porcentajeEnergia) {
        int tempEnergia = energia = (int)(energia * (1 + porcentajeEnergia / 100));
        int tempHumor;
        energia = tempEnergia > MAX_ENERGIA ? MAX_ENERGIA : tempEnergia;
        cantidadActividadesConsecutivas = 0;
        cantidadIngestasConsecutivas++;
        if (cantidadIngestasConsecutivas < 4) {
            tempHumor = humorCantidad + INGESTA_HUMOR;
            humorCantidad = tempHumor > MAX_HUMOR ? MAX_HUMOR : tempHumor;
        } else {
            tempHumor = humorCantidad - INGESTA_HUMOR;
            humorCantidad = tempHumor < 0 ? 0 : tempHumor;
            if(cantidadIngestasConsecutivas >= 5) {
                humorCantidad = 0;
            }
        }
        if (humorCantidad == 0) {
            aDormir();
        }
    }
}
