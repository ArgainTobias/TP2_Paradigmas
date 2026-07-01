package personajes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonajesTest {

	Auror a;
	Seguidor s;
	
	@BeforeEach
	public void preparar() {
		a = new Auror("Harry");
		s = new Seguidor("Volvemort");
	}
	
	@Test
    void auror_naceConValoresCorrectos() {
            // sin import, mismo paquete
        assertEquals(150, a.getHp());
    }

    @Test
    void recibirDanio_bajaElHp() {
        a.reducirHp(30);
        assertEquals(120, a.getHp());
    }

    @Test
    void recibirDanio_noBajaDeCero() {
        a.reducirHp(500);
        assertEquals(0, a.getHp());
    }
    


}
