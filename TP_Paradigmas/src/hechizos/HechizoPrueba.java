package hechizos;

import personajes.Personaje;

public class HechizoPrueba implements Hechizo{
	 @Override
		public int ejecutar(Personaje lanzador, Personaje objetivo) {
			objetivo.recibirDanio(10);
			return 0;
		}
}
