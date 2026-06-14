package main;
import reclutador.*;
import personajes.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("=== Reclutando magos ===");
        for (int i = 0; i < 5; i++) {
            Personaje mago = ReclutadorSimpleFactory.crearMago();
            System.out.println(mago);
        }

        System.out.println("\n=== Reclutando mortifagos ===");
        for (int i = 0; i < 5; i++) {
            Personaje mortifago = ReclutadorSimpleFactory.crearMortifago();
            System.out.println(mortifago);
        }
	}

}
