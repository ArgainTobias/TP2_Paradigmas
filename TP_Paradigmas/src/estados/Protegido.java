package estados;
import personajes.Personaje;

public class Protegido extends EstadoPersonaje{
	private int duracion;
	public Protegido(int duracion) {
		this.duracion=duracion;
	}
	@Override
	public EstadoPersonaje recibirDanio(Personaje p,int danio) {
		p.reducirHp(0);
		duracion--;
		if (duracion <= 0) {
			System.out.println(p.getNombre() + " pierde su proteccion");
            return new Sano();               // se acabó la protección, vuelve a Sano
        }
		return this;
	}
	
	@Override
	public EstadoPersonaje aturdir(Personaje p, int duracion) {
		duracion--;
		if(duracion==0) {			
			System.out.println(p.getNombre() + " pierde su proteccion");
			return new Sano();
		}
		
		return this;
	}
}
