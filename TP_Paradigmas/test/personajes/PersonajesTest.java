package personajes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonajesTest {

	@Test
    void auror_naceConValoresCorrectos() {
        Auror a = new Auror("Harry");        // sin import, mismo paquete
        assertEquals(100, a.getHp());
    }

    @Test
    void recibirDanio_bajaElHp() {
        Auror a = new Auror("Harry");
        a.reducirHp(30);
        assertEquals(70, a.getHp());
    }

    @Test
    void recibirDanio_noBajaDeCero() {
        Auror a = new Auror("Harry");
        a.reducirHp(500);
        assertEquals(0, a.getHp());
    }
    


}
