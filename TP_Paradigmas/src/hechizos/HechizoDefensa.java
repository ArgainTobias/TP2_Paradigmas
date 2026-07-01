package hechizos;

import batallon.Batallon;
import personajes.Personaje;

public abstract class HechizoDefensa implements Hechizo{

	@Override
	public Personaje seleccionarObjetivo(Personaje lanzador, Batallon propio, Batallon enemigo) {

		return lanzador;
	}
	
	//COMPARACION, HASH Y EQUALS PARA EL SET DE BATALLON
	
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof Hechizo)) {
			return false;
		}
		
		return this.getClass() == obj.getClass();
	}
	
	@Override
	public int hashCode() {
		return java.util.Objects.hash(this.getClass());
	}

}
