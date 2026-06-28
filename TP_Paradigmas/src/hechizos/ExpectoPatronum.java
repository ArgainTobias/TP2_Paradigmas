package hechizos;

import personajes.Personaje;

public class ExpectoPatronum implements Hechizo{

	 @Override
		public int ejecutar(Personaje lanzador, Personaje objetivo) {
			objetivo.recibirDanio(2000);
			return 0;
		}
	
}