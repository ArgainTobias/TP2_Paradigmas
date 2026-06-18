package hechizos;

import personajes.Personaje;

public class AvadaKedavra implements Hechizo {
	@Override
	public int ejecutar(Personaje lanzador, Personaje objetivo) {
		objetivo.aturdir(1);
		return 0;
	}
}
