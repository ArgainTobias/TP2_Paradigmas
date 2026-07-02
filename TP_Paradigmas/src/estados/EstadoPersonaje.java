package estados;
import personajes.Personaje;

public abstract class EstadoPersonaje {
	public EstadoPersonaje recibirDanio(Personaje p, int danio) {
		return this;
	}
	public EstadoPersonaje proteger(Personaje p, int duracion) {
		return this;
	}
	
	public EstadoPersonaje aturdir(Personaje p, int duracion) {
		return this;
	}
	
	public EstadoPersonaje pasarTurno(Personaje p,int duracion) {
		return this;
	}
	
	public boolean puedeActuar() {
		return true;
	}
	
	public boolean puedeSerObjetivo() {
		return true;
	}
	
}
