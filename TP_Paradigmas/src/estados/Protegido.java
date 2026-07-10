package estados;
import personajes.Personaje;

public class Protegido extends EstadoPersonaje{
	private int duracion;
	public Protegido(int duracion) {
		this.duracion=duracion;
	}
	@Override
	public EstadoPersonaje recibirDanio(Personaje p,int danio) {		
		
		if(danio<=0) {
			p.reducirHp(danio);
			return this;
		}
		
		p.reducirHp(0);
		duracion--;
		
		if (duracion <= 0) {
			System.out.println("--"+p.getNombre() +" ("+ p.getHp()+"HP) pierde su proteccion");
            return new Sano();               // se acabó la protección, vuelve a Sano
        }
		return this;
	}
	
	@Override
	public EstadoPersonaje aturdir(Personaje p, int duracion) {
		this.duracion--;
		if(duracion==0) {			
			System.out.println("--"+p.getNombre() +" ("+ p.getHp()+"HP) pierde su proteccion");
			return new Sano();
		}
		
		return this;
	}
}
