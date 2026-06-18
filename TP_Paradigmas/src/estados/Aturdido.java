package estados;
import personajes.Personaje;


public class Aturdido extends EstadoPersonaje{
	private int duracion;
	public Aturdido(int duracion) {
		this.duracion=duracion;
	}
	
	@Override
    public EstadoPersonaje recibirDanio(Personaje p, int danio) {
        p.reducirHp(danio);                  // daño completo
        if (p.getHp() <= 0) {
            return new Muerto();
        }
        return this;
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
