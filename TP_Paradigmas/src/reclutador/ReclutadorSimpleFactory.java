package reclutador;

import java.util.List;
import java.util.Random;

import personajes.*;

public class ReclutadorSimpleFactory {
	private static Random rand = new Random();
	private static List<String> nombres = List.of("Harry", "Hermione", "Ron", "Dumbledore", "Bellatrix",
			"Lucius", "Voldemort", "McGonagall", "Neville", "Dolohov");
	
	public static Personaje crearMago() {
		String nombre = nombres.get(rand.nextInt(nombres.size()));
		int t = rand.nextInt(3); // 0, 1 o 2
		if (t == 0)
			return new Auror(nombre);
		if (t == 1)
			return new Estudiante(nombre);
		return new Profesor(nombre);
	}

	public static Personaje crearMortifago() {
		String nombre = nombres.get(rand.nextInt(nombres.size()));
		boolean t = rand.nextBoolean();
		if (t)
			return new Seguidor(nombre);
		return new Comandante(nombre);
	}
}
