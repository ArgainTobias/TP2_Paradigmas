package main;
import reclutador.ReclutadorSimpleFactory;
import java.util.Random;

import batallon.Batallon;

public class Main {

	public static void main(String[] args) {
		
			int i=1;
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
            System.out.println("-----------ARRANCA LA BATALLA--------------");
            
            while (batallonMagos.tienePersonajesSaludables() && batallonMortifagos.tienePersonajesSaludables()) {
            	System.out.println("------------Turno "+ i +"----------------");
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
                i++;           
              }
            
            	System.out.println("----------------------------");
              if (batallonMagos.tienePersonajesSaludables()) {
                System.out.println("¡Los magos han ganado la batalla!");
              } else {
                System.out.println("¡Los mortífagos han ganado la batalla!");
              }
            }
        }
	
		
       
