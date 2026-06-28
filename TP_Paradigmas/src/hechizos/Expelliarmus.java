package hechizos;

import personajes.Personaje;

public class Expelliarmus implements Hechizo{
	
	 @Override
	public int ejecutar(Personaje lanzador, Personaje objetivo) {
		objetivo.reducirHp(10);
		return 0;
	}
}
