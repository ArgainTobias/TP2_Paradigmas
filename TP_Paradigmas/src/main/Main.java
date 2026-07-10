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
                  System.out.println(batallonMagos.atacar(batallonMortifagos));
                  if (batallonMortifagos.tienePersonajesSaludables()) {
                	  System.out.println(batallonMortifagos.atacar(batallonMagos));
                  }
                } else {
                	System.out.println(batallonMortifagos.atacar(batallonMagos));
                  if (batallonMagos.tienePersonajesSaludables()) {
                	  System.out.println(batallonMagos.atacar(batallonMortifagos));
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
              System.out.println("----------------SECUENCIA MAGOS-------------------");
              batallonMagos.mostrarSecuencia();
              System.out.println("----------------SECUENCIA MORTIFAGOS-------------------");
              batallonMortifagos.mostrarSecuencia();
	}
			 
			 
	
	
        }
	
		
       
