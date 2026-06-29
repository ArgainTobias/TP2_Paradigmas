package hechizos;
import personajes.Personaje;

public class Protego implements Hechizo{
	@Override
	public int ejecutar(Personaje lanzador, Personaje objetivo) {
		lanzador.proteger(3);
		return 0;
	}
	
	@Override
	public String toString() {
	    return getClass().getSimpleName();
	}
}
