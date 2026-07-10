package testBatallonReclutador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import batallon.Batallon;
import hechizos.Anapneo;
import hechizos.AvadaKedavra;
import hechizos.ExpectoPatronum;
import hechizos.Expelliarmus;
import hechizos.Imperio;
import hechizos.Protego;
import personajes.Auror;
import personajes.Comandante;
import personajes.Estudiante;
import personajes.Personaje;
import personajes.Profesor;
import personajes.Seguidor;
import reclutador.ReclutadorSimpleFactory;

class TestBatallonReclutador {
	
	Batallon batallon;
	
    //personajes
    
	Auror harry;
	Auror harry2;
	Auror ron;
	Profesor dumbledore;
	Estudiante neville;
	Comandante voldemort;
	Seguidor crouch;
	
	//hechizos
	
	Expelliarmus expe;
	Anapneo anap;
	AvadaKedavra avada;
	Protego prot;
	Imperio imp;
	ExpectoPatronum patro;
	
	@BeforeEach
	public void preparar() {
		
		batallon = new Batallon();
	    
		harry = new Auror("Harry");
		harry2 = new Auror("Harry");
		ron = new Auror("Jesus");
		voldemort = new Comandante("Voldemort");
		crouch = new Seguidor("Carlos");
		neville = new Estudiante("Miguel");
		dumbledore= new Profesor("Dumbledore");
		
		expe = new Expelliarmus();
		anap = new Anapneo();
		avada = new AvadaKedavra();
		prot = new Protego();
		imp = new Imperio();
		patro = new ExpectoPatronum();
		}
	
	// Test de Batallon
	
	@Test
	public void testBatallonIniciaVacio() {
	    assertEquals(0, batallon.getCantSoldados());
	}
	
	@Test
	public void testAgregarPersonaje() {
	    batallon.agregarPersonaje(harry);
	    assertEquals(1, batallon.getCantSoldados());
	}
	
	@Test
	public void testNoPermitePersonajesDuplicados() {

	    batallon.agregarPersonaje(harry);
	    batallon.agregarPersonaje(harry2);

	    assertEquals(1, batallon.getCantSoldados());
	}
	
	@Test
	public void testBatallonDerrotado() {
		batallon.agregarPersonaje(harry);
	    harry.recibirDanio(9999);
	    batallon.agregarPersonaje(harry);

	    assertFalse(batallon.tienePersonajesSaludables());
	}
	
	@Test
    void batalla1() {
		System.out.println("\nBatalla 1\n");
		harry.lanzarHechizo(patro, voldemort);
		
		harry.lanzarHechizo(expe, voldemort);
		voldemort.lanzarHechizo(expe, harry);
		
		harry.lanzarHechizo(expe, voldemort);
		voldemort.lanzarHechizo(imp, harry);
		
		voldemort.lanzarHechizo(expe, harry);
		
		
		harry.lanzarHechizo(expe, voldemort);
		voldemort.lanzarHechizo(expe, harry);
		
		assertEquals("Muerto", voldemort.getEstado().getClass().getSimpleName());
    }
	
	@Test
    void batalla2() {
        System.out.println("\nBatalla 2\n");
		harry.lanzarHechizo(expe, voldemort);
		voldemort.lanzarHechizo(expe, harry);
		
		harry.lanzarHechizo(prot,harry);
		voldemort.lanzarHechizo(avada, harry);
		
		harry.lanzarHechizo(expe, voldemort);
		voldemort.lanzarHechizo(avada, harry);
		
		assertEquals("Muerto", harry.getEstado().getClass().getSimpleName());
    }
	
	// Test de Reclutador
	
	@Test
	public void testCrearMagoNoDevuelveNull() {
	    Personaje nuevoMago = ReclutadorSimpleFactory.crearMago();
	    assertNotNull(nuevoMago);
	}
	
	@Test // el objeto creado pertenece a la familia 
	public void testCrearMagoDevuelveUnPersonaje() { 
	    Object entidad = ReclutadorSimpleFactory.crearMago();
	    assertTrue(entidad instanceof Personaje);
	}
	
	@Test
	public void testMagoNaceConAtributosValidos() {
	    Personaje mago = ReclutadorSimpleFactory.crearMago();

	    assertNotNull(mago.getNombre());
	    assertNotEquals("", mago.getNombre()); // El nombre no debe estar vacío
	    assertTrue(mago.getHp() > 0); // Debe nacer vivo
	}
}
