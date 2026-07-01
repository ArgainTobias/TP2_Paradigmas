package hechizos;

import batallon.Batallon;
import personajes.Personaje;

public abstract class HechizoAtaque implements Hechizo{

	@Override
	public Personaje seleccionarObjetivo(Personaje lanzador, Batallon propio, Batallon enemigo) {
		
		return enemigo.getPersonajesSaludables().get(0);
	}

}
