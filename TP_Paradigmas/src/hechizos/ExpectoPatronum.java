package hechizos;

import personajes.Personaje;

public class ExpectoPatronum implements Hechizo{
	
	 @Override
	public int ejecutar(Personaje lanzador, Personaje objetivo) {
		objetivo.reducirHp(20);
		return 0;
	}
}