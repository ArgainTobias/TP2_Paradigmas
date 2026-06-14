package hechizos;
import personajes.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HechizoTest {

	@Test
	void test() {
		Auror a = new Auror("Prueba");
		Seguidor s = new Seguidor("Prueba");
		s.lanzarHechizo(s.getHechizos().get(0), a);
		assertEquals(90,a.getHp());
		s.lanzarHechizo(s.getHechizos().get(0), a);
		assertEquals(80,a.getHp());
	}

}
