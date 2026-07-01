package hechizos;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personajes.Auror;
import personajes.Seguidor;

class HechizoTest {

	Auror a;
	Seguidor s;
	Expelliarmus expe;
	
	@BeforeEach
	public void preparar() {
		a = new Auror("Harry");
		s = new Seguidor("Voldemort");
		expe = new Expelliarmus();
	}
	
	@Test
	void testExpelliarmus() {
		s.lanzarHechizo(expe, a);
		s.lanzarHechizo(expe, a);
		assertEquals(130,a.getHp());
		s.lanzarHechizo(expe, a);
		assertEquals(120,a.getHp());
	}

}
