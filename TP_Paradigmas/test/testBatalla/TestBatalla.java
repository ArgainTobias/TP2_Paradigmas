package testBatalla;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import batallon.Batallon;
import estados.Aturdido;
import hechizos.Anapneo;
import hechizos.AvadaKedavra;
import hechizos.ExpectoPatronum;
import hechizos.Expelliarmus;
import hechizos.Imperio;
import hechizos.Protego;
import personajes.Auror;
import personajes.Comandante;
import personajes.Estudiante;
import personajes.Profesor;
import personajes.Seguidor;
import reclutador.ReclutadorSimpleFactory;

class TestBatalla {

	//mortifagos
	
//	Batallon batallonMagos;
//    Batallon batallonMortifagos;
	
    //personajes
    
	Auror harry;
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
		
//		batallonMagos = new Batallon();
//	    batallonMortifagos = new Batallon();
//		
//	    while(batallonMagos.getCantSoldados()!=3) {
//        	batallonMagos.agregarPersonaje(ReclutadorSimpleFactory.crearMago());	
//        	
//		}
//        batallonMagos.mostrarBatallon();
//        System.out.println("=== Batallon mortifagos ===");
//        while(batallonMortifagos.getCantSoldados()!=3) {
//        	batallonMortifagos.agregarPersonaje(ReclutadorSimpleFactory.crearMortifago());				
//		}
//        batallonMortifagos.mostrarBatallon();
	    
		harry = new Auror("Harry");
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

    


}
