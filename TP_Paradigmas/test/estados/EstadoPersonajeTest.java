package estados;
import personajes.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EstadoPersonajeTest {

	@Test
    void sano_recibeDanioCompleto() {
        Auror a = new Auror("Harry");      // arranca Sano, HP 100
        a.recibirDanio(30);
        assertEquals(70, a.getHp());        // daño completo: 100 - 30
    }

    @Test
    void sano_puedeActuar() {
        Auror a = new Auror("Harry");
        assertTrue(a.puedeActuar());
    }
 // --- Transición a Protegido ---

    @Test
    void protegido_recibeMitadDeDanio() {
        Auror a = new Auror("Harry");
        a.proteger(3);                      // pasa a Protegido
        a.recibirDanio(40);
        assertEquals(80, a.getHp());        // mitad: 100 - 20
    }

    @Test
    void protegido_vuelveASanoTrasAgotarDuracion() {
        Auror a = new Auror("Harry");
        a.proteger(2);                      // protegido por 2 ataques
        a.recibirDanio(10);                 // ataque 1: mitad (5) → HP 95, queda 1 de duración
        a.recibirDanio(10);                 // ataque 2: mitad (5) → HP 90, duración agotada → vuelve a Sano
        a.recibirDanio(10);                 // ataque 3: ya Sano, daño completo (10) → HP 80
        assertEquals(80, a.getHp());
    }

    // --- Transición a Aturdido ---

    @Test
    void aturdido_noPuedeActuar() {
        Auror a = new Auror("Harry");
        a.aturdir(1);
        assertFalse(a.puedeActuar());
    }

    // --- Transición a Muerto ---

    @Test
    void muerto_cuandoHpLlegaACero() {
        Auror a = new Auror("Harry");       // HP 100
        a.recibirDanio(150);                // daño mayor que el HP
        assertEquals(0, a.getHp());         // no baja de 0
        assertFalse(a.puedeActuar());       // un muerto no puede actuar
    }

    @Test
    void muerto_noRecibeMasDanio() {
        Auror a = new Auror("Harry");
        a.recibirDanio(150);                // muere
        a.recibirDanio(50);                 // intenta pegarle de nuevo
        assertEquals(0, a.getHp());         // sigue en 0, no baja más
    }
}
