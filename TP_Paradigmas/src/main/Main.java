package main;
import reclutador.ReclutadorSimpleFactory;
import java.util.Random;

import batallon.Batallon;

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

            while (batallonMagos.tienePersonajesSaludables() && batallonMortifagos.tienePersonajesSaludables()) {
            	 
                // los ataques pueden tener salidas por pantalla para mostrar lo que sucede
                if (rand.nextBoolean()) {
                  batallonMagos.atacar(batallonMortifagos);
                  if (batallonMortifagos.tienePersonajesSaludables()) {
                    batallonMortifagos.atacar(batallonMagos);
                  }
                } else {
                  batallonMortifagos.atacar(batallonMagos);
                  if (batallonMagos.tienePersonajesSaludables()) {
                    batallonMagos.atacar(batallonMortifagos);
                  }
                }
           
                System.out.println("----------------------------");
              }
           
              if (batallonMagos.tienePersonajesSaludables()) {
                System.out.println("¡Los magos han ganado la batalla!");
              } else {
                System.out.println("¡Los mortífagos han ganado la batalla!");
              }
            }
        }
	
		
       
