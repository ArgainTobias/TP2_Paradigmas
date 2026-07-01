package hechizos;

import personajes.Personaje;

public class Protego extends HechizoDefensa{
	@Override
	public String ejecutar(Personaje lanzador, Personaje objetivo) {
		String msj = lanzador.getNombre() + " se lanza " + this.getClass().getSimpleName() + " a si mismo";
		System.out.println(msj);
		lanzador.proteger(2);
		return msj;
	}
	
	@Override
	public String toString() {
	    return getClass().getSimpleName();
	}
}
