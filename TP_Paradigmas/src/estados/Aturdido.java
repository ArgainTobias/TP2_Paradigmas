package estados;
import personajes.Personaje;


public class Aturdido extends EstadoPersonaje{
	private int duracion;
	public Aturdido(int duracion) {
		this.duracion=duracion;
	}
	
	public EstadoPersonaje pasarTurno() {
		duracion--;
		if(duracion <=0) {
			return new Sano();
		}
		return this;
	}
	
	@Override
	public boolean puedeActuar() {
		return false;
	}
	
}
