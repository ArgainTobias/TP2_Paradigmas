package estados;
import personajes.Personaje;

public class Protegido extends EstadoPersonaje{
	private int duracion;
	public Protegido(int duracion) {
		this.duracion=duracion;
	}
	@Override
	public EstadoPersonaje recibirDanio(Personaje p,int danio) {
		p.reducirHp(danio/2);
		duracion--;
		if(p.getHp()<=0) {
			return new Muerto();
		}
		if (duracion <= 0) {
            return new Sano();               // se acabó la protección, vuelve a Sano
        }
		return this;
	}
	
	
}
