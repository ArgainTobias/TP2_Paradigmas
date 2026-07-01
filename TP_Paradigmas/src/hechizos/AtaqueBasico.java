package hechizos;
import personajes.Personaje;

public class AtaqueBasico implements Hechizo{
	@Override
	public int ejecutar(Personaje lanzador, Personaje objetivo) {
		objetivo.reducirHp(5);
		return 0;
	}
}
