package hechizos;

import personajes.Personaje;

public class AvadaKedavra extends HechizoAtaque {
	@Override
	public String ejecutar(Personaje lanzador, Personaje objetivo) {

		objetivo.recibirDanio(objetivo.getHp()); // el avadaKedabra te mata de una
		String msj = lanzador.getNombre() + "(" + lanzador.getHp() + " HP) lanza " + getClass().getSimpleName() + " a "
				+ objetivo.getNombre() + " (100% HP)";
		// System.out.println(msj);
		if (objetivo.getHp() <= 0) {
			msj += "\n - ¡" + objetivo.getNombre() + " ha caído!";
		}else {
			msj += "\n - ¡" + objetivo.getNombre() + " ha sobrevivido al ataque!";
		}
		return msj;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}
