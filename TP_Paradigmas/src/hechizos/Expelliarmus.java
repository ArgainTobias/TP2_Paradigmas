package hechizos;

import personajes.Personaje;

public class Expelliarmus extends HechizoAtaque{
	
	 @Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		objetivo.recibirDanio(10);
		objetivo.aturdir(1);
	}
	 
	 @Override
		public String toString() {
		    return getClass().getSimpleName();
		}
}
