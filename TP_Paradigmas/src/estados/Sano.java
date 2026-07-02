package estados;

import personajes.Personaje;

public class Sano extends EstadoPersonaje {
	public EstadoPersonaje recibirDanio(Personaje p, int danio) {
		p.reducirHp(danio);
		if (p.getHp() <= 0) {
			System.out.println(p.getNombre() + " ha muerto");
			return new Muerto();
		}
		return this;
	}

	@Override
	public EstadoPersonaje aturdir(Personaje p, int duracion) {
		System.out.println(p.getNombre() + " esta aturdido");
		return new Aturdido(duracion);
	}
	
	@Override
    public EstadoPersonaje proteger(Personaje p, int duracion) {
		System.out.println(p.getNombre() + " esta protegido");
        return new Protegido(duracion);             // pasa a Protegido (3 ataques de duración)
    }
}
