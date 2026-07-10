package hechizos;

import personajes.Personaje;

public class Protego extends HechizoDefensa {
	@Override
	public String ejecutar(Personaje lanzador, Personaje objetivo) {
		lanzador.proteger(1);
		String msj = lanzador.getNombre() + "(" + lanzador.getHp() + "HP)se lanza " + this.getClass().getSimpleName()
				+ " a si mismo \n¡" + lanzador.getNombre() + " esta protegido por 1 turno!";
		//System.out.println(msj);
		return msj;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}
