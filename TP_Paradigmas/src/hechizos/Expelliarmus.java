package hechizos;

import personajes.Personaje;

public class Expelliarmus implements Hechizo{
	
	 @Override
	public int ejecutar(Personaje lanzador, Personaje objetivo) {
		objetivo.reducirHp(10);
		objetivo.aturdir(1);
		return 0;
	}
	 
	 @Override
		public String toString() {
		    return getClass().getSimpleName();
		}
}
