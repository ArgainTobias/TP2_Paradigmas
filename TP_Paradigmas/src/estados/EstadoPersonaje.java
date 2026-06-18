package estados;
import personajes.Personaje;

public abstract class EstadoPersonaje {
	public EstadoPersonaje recibirDanio(Personaje p, int danio) {
		return this;
	}
	public EstadoPersonaje proteger(int duracion) {
		return this;
	}
	
	public EstadoPersonaje aturdir(int duracion) {
		return this;
	}
	
	public boolean puedeActuar() {
		return true;
	}
	
	public boolean puedeSerObjetivo() {
		return true;
	}
	
}
