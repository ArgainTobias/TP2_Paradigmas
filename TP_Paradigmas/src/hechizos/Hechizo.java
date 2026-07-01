package hechizos;
import batallon.Batallon;
import personajes.Personaje;

public interface Hechizo {
	
	String ejecutar(Personaje lanzador, Personaje objetivo);
	Personaje seleccionarObjetivo(Personaje lanzador, Batallon propio, Batallon enemigo);
}
