package hechizos;

import java.util.Random;

import batallon.Batallon;
import personajes.Personaje;

public abstract class HechizoAtaque implements Hechizo{

	protected int danioBase;
	
	@Override
	public Personaje seleccionarObjetivo(Personaje lanzador, Batallon propio, Batallon enemigo) {
		
		Random rand = new Random();
		
		int cantSaludables = enemigo.getPersonajesSaludables().size();
		if(cantSaludables>0) {
			int indiceObjetivo = rand.nextInt(cantSaludables);			
			return enemigo.getPersonajesSaludables().get(indiceObjetivo);
		}
		return null;
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
