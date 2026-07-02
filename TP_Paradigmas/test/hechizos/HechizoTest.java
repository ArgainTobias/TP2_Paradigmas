package hechizos;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import estados.Aturdido;
import personajes.Auror;
import personajes.Comandante;
import personajes.Estudiante;
import personajes.Seguidor;

class HechizoTest {

	Auror a;
	Auror a2;
	Seguidor s;
	Comandante c;
	Estudiante e;
	
	Expelliarmus expe;
	Anapneo anap;
	AvadaKedavra avada;
	Protego prot;
	Imperio imp;
	ExpectoPatronum patro;
	Aturdido aturd;
	
	@BeforeEach
	public void preparar() {
		a = new Auror("Harry");
		a2 = new Auror("Jesus");
		s = new Seguidor("Voldemort");
		c = new Comandante("Carlos");
		e = new Estudiante("Miguel");
		
		expe = new Expelliarmus();
		anap = new Anapneo();
		avada = new AvadaKedavra();
		prot = new Protego();
		imp = new Imperio();
		patro = new ExpectoPatronum();
		}
	
	@Test
	void testExpelliarmus() {
		s.lanzarHechizo(expe, a);
		c.lanzarHechizo(expe, a);
		assertEquals(110,a.getHp());
	}
	
	@Test
	void testAnapneo(){
		s.lanzarHechizo(expe, a2);
		e.lanzarHechizo(anap, a2);
		assertEquals(160,a2.getHp());
	}
	
	@Test
	void testAvadaKedavra(){
		s.lanzarHechizo(avada, a2);
		
		assertEquals(0,a2.getHp());
		assertEquals("Muerto",a2.getEstado().getClass().getSimpleName());
	}
	
	@Test
	void testProtego(){
		a2.lanzarHechizo(prot, a2);
		assertEquals("Protegido",a2.getEstado().getClass().getSimpleName());
		
		s.lanzarHechizo(expe, a2);
		assertEquals(150,a2.getHp());
		
		s.lanzarHechizo(expe, a2);
		assertEquals(140,a2.getHp());
		
		a2.lanzarHechizo(prot, a2);
		s.lanzarHechizo(imp,a2);
		assertEquals("Sano",a2.getEstado().getClass().getSimpleName());
	}
	
	@Test
	void testImperio(){
		s.lanzarHechizo(imp, a2);
		assertEquals("Aturdido",a2.getEstado().getClass().getSimpleName());
	}
	
	@Test
	void testPatronum(){
		a2.lanzarHechizo(patro, s);
		assertEquals("Aturdido",s.getEstado().getClass().getSimpleName());
	}
	
	
}
