package main;
import personajes.Batallon;
import reclutador.ReclutadorSimpleFactory;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
	/*	tem.out.println("=== Reclutando magos ===");
	 
        for (int i = 0; i < 5; i++) {
            Personaje mago = ReclutadorSimpleFactory.crearMago();
            System.out.println(mago);
        }

        System.out.println("\n=== Reclutando mortifagos ===");
        for (int i = 0; i < 5; i++) {
            Personaje mortifago = ReclutadorSimpleFactory.crearMortifago();
            System.out.println(mortifago);
           */ 
			Random rand = new Random();
            Batallon batallonMagos = new Batallon();
            Batallon batallonMortifagos = new Batallon();
            System.out.println("=== Batallon magos ===");
            while(batallonMagos.getCantSoldados()!=3) {
            	batallonMagos.agregarPersonaje(ReclutadorSimpleFactory.crearMago());	
            	
			}
            batallonMagos.mostrarBatallon();
            System.out.println("=== Batallon mortifagos ===");
            while(batallonMortifagos.getCantSoldados()!=3) {
            	batallonMortifagos.agregarPersonaje(ReclutadorSimpleFactory.crearMortifago());				
			}
            batallonMortifagos.mostrarBatallon();   
            
            while(batallonMagos.tienePersonajesSaludables() && batallonMortifagos.tienePersonajesSaludables()) {
            	if(rand.nextBoolean()) {
            		//batallonMagos.atacar(batallonMortifagos);
            	}
            }
        }
        
	}
