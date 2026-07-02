package hechizos;

import java.util.Random;

import batallon.Batallon;
import personajes.Personaje;

public abstract class HechizoAmistoso implements Hechizo{

	@Override
	public Personaje seleccionarObjetivo(Personaje lanzador, Batallon propio, Batallon enemigo) {
		
		Random rand = new Random();
		
		int cantSaludables = propio.getPersonajesSaludables().size();
		if(cantSaludables>0) {
			int indiceObjetivo = rand.nextInt(cantSaludables);			
			return propio.getPersonajesSaludables().get(indiceObjetivo);
		}
		return null;		
	}
	
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
