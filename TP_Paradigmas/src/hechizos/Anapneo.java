package hechizos;

import personajes.Personaje;

public class Anapneo extends HechizoAmistoso {

	@Override
	public String ejecutar(Personaje lanzador, Personaje objetivo) {
		int cura = -20 * lanzador.getLvl();
		String msj = lanzador.getNombre() + " (" + lanzador.getHp() + "HP) cura usando " + getClass().getSimpleName()
				+ " a " + objetivo.getNombre() + " (" + (objetivo.getHp() - cura) + "HP)";
		System.out.println(msj);
		objetivo.recibirDanio(cura);
		return msj;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}

}
