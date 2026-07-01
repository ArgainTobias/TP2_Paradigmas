package hechizos;

import batallon.Batallon;
import personajes.Personaje;

public abstract class HechizoDefensa implements Hechizo{

	@Override
	public Personaje seleccionarObjetivo(Personaje lanzador, Batallon propio, Batallon enemigo) {

		return lanzador;
	}

}
