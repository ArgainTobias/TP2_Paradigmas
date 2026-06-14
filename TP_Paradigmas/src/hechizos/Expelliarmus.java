package hechizos;

import personajes.Personaje;

public class Expelliarmus implements Hechizo{ //hola
	
	 @Override
	public int ejecutar(Personaje lanzador, Personaje objetivo) {
		objetivo.recibirDanio(10);
		return 0;
	}
}
