package hechizos;

import personajes.Personaje;

public class Protego implements Hechizo{
	
	 @Override
	public int ejecutar(Personaje lanzador, Personaje objetivo) {
		objetivo.recibirDanio(-100000);
		return 0;
	}
}