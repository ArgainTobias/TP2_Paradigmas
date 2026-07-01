package hechizos;

import personajes.Personaje;

public class ExpectoPatronum extends HechizoAtaque{
	
	 @Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		objetivo.recibirDanio(20);
	}
}