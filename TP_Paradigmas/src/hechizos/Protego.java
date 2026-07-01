package hechizos;

import personajes.Personaje;

public class Protego extends HechizoDefensa{
	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		lanzador.proteger(1);
	}
	
	@Override
	public String toString() {
	    return getClass().getSimpleName();
	}
}
