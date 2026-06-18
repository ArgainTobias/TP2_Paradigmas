package estados;

public class Muerto extends EstadoPersonaje{
	@Override
	public boolean puedeSerObjetivo() {
		return false;
	}
	
	@Override
	public boolean puedeActuar() {
		return false;
	}
	
}
