package tamagotchi;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MascotaVirtualTest {

    @Test
    public void testComer() {
        MascotaVirtual mascota = new MascotaVirtual("Fido");
        int energiaInicial = mascota.getEnergia();
        boolean result = mascota.comer();
        assertTrue(result);
        assertEquals((int)(energiaInicial * 1.15), mascota.getEnergia());
    }

    @Test
    public void testCorrer() {
        MascotaVirtual mascota = new MascotaVirtual("Fido");
        int energiaInicial = mascota.getEnergia();
        boolean result = mascota.correr();
        assertTrue(result);
        assertEquals(energiaInicial - 12, mascota.getEnergia());
    }

    @Test
    public void testSaltar() {
        MascotaVirtual mascota = new MascotaVirtual("Fido");
        int energiaInicial = mascota.getEnergia();
        String humorInicial = mascota.getHumor();
        boolean result = mascota.saltar();
        assertTrue(result);
        assertEquals(energiaInicial - 22, mascota.getEnergia());
        assertEquals(MascotaVirtual.HUMORES[buscarIndiceHumor(humorInicial) + 1], mascota.getHumor());
    }

    @Test
    public void testDormir() {
        MascotaVirtual mascota = new MascotaVirtual("Fido");
        int energiaInicial = mascota.getEnergia();
        String humorInicial = mascota.getHumor();
        boolean result = mascota.dormir();
        assertTrue(result);
        assertEquals((int)(energiaInicial * 1.2), mascota.getEnergia());
        assertEquals(MascotaVirtual.HUMORES[buscarIndiceHumor(humorInicial) - 2], mascota.getHumor());
    }

    private int buscarIndiceHumor(String h){
        for (int i = 0; i < MascotaVirtual.HUMORES.length; i++) {
            if (MascotaVirtual.HUMORES[i].equals(h))
                return i;
        }
        return -1;
    }
}