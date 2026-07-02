package estados;

import personajes.Personaje;

public class Aturdido extends EstadoPersonaje {
	private int duracion;

	public Aturdido(int duracion) {
		this.duracion = duracion;
	}

	@Override
    public EstadoPersonaje recibirDanio(Personaje p, int danio) {
        p.reducirHp(danio);                  // daño completo
        if (p.getHp() <= 0) {
        	System.out.println(p.getNombre() + " ha muerto (0 HP)");
            return new Muerto();
        }
        return this;
    }
	
	@Override
	public EstadoPersonaje pasarTurno(Personaje p, int duracion) {
		duracion--;
		if(duracion <=0) {
			System.out.println(p.getNombre() + " se recupera");
			return new Sano();
		}
		return this;
	}

	@Override
	public boolean puedeActuar() {
		return false;
	}

}
