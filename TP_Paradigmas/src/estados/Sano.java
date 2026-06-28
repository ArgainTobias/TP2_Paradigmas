package estados;

import personajes.Personaje;

public class Sano extends EstadoPersonaje {
	public EstadoPersonaje recibirDanio(Personaje objetivo, int danio) {
		objetivo.reducirHp(danio);
		if (objetivo.getHp() <= 0) {
			return new Muerto();
		}
		return this;
	}

	@Override
	public EstadoPersonaje aturdir(int duracion) {
		return new Aturdido(duracion);
	}
	
	@Override
    public EstadoPersonaje proteger(int duracion) {
        return new Protegido(duracion);             // pasa a Protegido (3 ataques de duración)
    }
}
