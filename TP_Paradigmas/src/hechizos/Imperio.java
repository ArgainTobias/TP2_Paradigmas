package hechizos;

import personajes.Personaje;

public class Imperio extends HechizoAtaque {

	@Override
	public String ejecutar(Personaje lanzador, Personaje objetivo) {

		String msj = lanzador.getNombre() + "(" + lanzador.getHp() + " HP) lanza " + getClass().getSimpleName() + " a "
				+ objetivo.getNombre() + "(" + objetivo.getHp() + " HP)";
		//System.out.println(msj);
		objetivo.aturdir(1);
		if (objetivo.getHp() > 0) {
			if (!objetivo.puedeActuar()) {
				msj += "\n - ¡" + objetivo.getNombre() + " ha sido aturdido!";
			}
		} else {
			msj += "\n - ¡" + objetivo.getNombre() + " ha muerto!";
		}
		return msj;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}
