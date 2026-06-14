package hechizos;
import personajes.Personaje;

public interface Hechizo {
	int ejecutar(Personaje lanzador, Personaje objetivo);
}
