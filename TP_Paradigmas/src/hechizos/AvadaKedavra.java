package hechizos;

import personajes.Personaje;

public class AvadaKedavra implements Hechizo {
	@Override
	public int ejecutar(Personaje lanzador, Personaje objetivo) {
		objetivo.aturdir(1);
		objetivo.reducirHp(150); //el avadaKedabra te mata de una
		return 0;
	}
	
	@Override
	public String toString() {
	    return getClass().getSimpleName();
	}
}
