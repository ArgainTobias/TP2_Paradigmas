package estados;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personajes.Auror;

class EstadoPersonajeTest {

	Auror a;
	
	@BeforeEach
	public void preparar(){
		a = new Auror("Harry");
	}
	
	@Test
    void sano_recibeDanioCompleto() {
     // arranca Sano, HP 150
        a.recibirDanio(30);
        assertEquals(120, a.getHp());        // daño completo: 100 - 30
    }

    @Test
    void sano_puedeActuar() {   
        assertTrue(a.puedeActuar());
    }
 // --- Transición a Protegido ---

    @Test
    void protegido_recibeMitadDeDanio() {
        a.proteger(3);                      // pasa a Protegido
        a.recibirDanio(40);
        assertEquals(150, a.getHp());        // mitad: 100 - 20
    }

    @Test
    void protegido_vuelveASanoTrasAgotarDuracion() {
        a.proteger(2);                      // protegido por 2 ataques
        a.recibirDanio(10);                 // ataque 1: mitad (5) → HP 95, queda 1 de duración
        a.recibirDanio(10);                 // ataque 2: mitad (5) → HP 90, duración agotada → vuelve a Sano
        a.recibirDanio(10);                 // ataque 3: ya Sano, daño completo (10) → HP 80
        assertEquals(140, a.getHp());
    }

    // --- Transición a Aturdido ---

    @Test
    void aturdido_noPuedeActuar() {
        a.aturdir(1);
        assertFalse(a.puedeActuar());
    }

    // --- Transición a Muerto ---

    @Test
    void muerto_cuandoHpLlegaACero() {
    	// HP 100
        a.recibirDanio(150);                // daño mayor que el HP
        assertEquals(0, a.getHp());         // no baja de 0
        assertFalse(a.puedeActuar());       // un muerto no puede actuar
    }

    @Test
    void muerto_noRecibeMasDanio() {
        a.recibirDanio(150);                // muere
        a.recibirDanio(50);                 // intenta pegarle de nuevo
        assertEquals(0, a.getHp());         // sigue en 0, no baja más
    }
}
