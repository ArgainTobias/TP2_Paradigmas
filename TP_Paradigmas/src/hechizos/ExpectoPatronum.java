package hechizos;

import personajes.Personaje;

public class ExpectoPatronum extends HechizoAtaque {

	@Override
	public String ejecutar(Personaje lanzador, Personaje objetivo) {

		String msj = lanzador.getNombre() + "(" + lanzador.getHp() + " HP) lanza " + getClass().getSimpleName() + " a "
				+ objetivo.getNombre() + " (-" + 25 * lanzador.getLvl() + " HP)";
		System.out.println(msj);
		objetivo.recibirDanio(25 * lanzador.getLvl());
		objetivo.aturdir(1);
		return msj;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}