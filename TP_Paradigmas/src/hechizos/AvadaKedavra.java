package hechizos;

import personajes.Personaje;

public class AvadaKedavra extends HechizoAtaque {
	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		objetivo.recibirDanio(objetivo.getHp()); //el avadaKedabra te mata de una
	}
	
	@Override
	public String toString() {
	    return getClass().getSimpleName();
	}
}
