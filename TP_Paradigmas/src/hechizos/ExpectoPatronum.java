package hechizos;

import personajes.Personaje;

public class ExpectoPatronum extends HechizoAtaque{
	
	 @Override
	public String ejecutar(Personaje lanzador, Personaje objetivo) {
		
		String msj = lanzador.getNombre() + " lanza " + getClass().getSimpleName() + " a " + objetivo.getNombre();
		System.out.println(msj);
		objetivo.recibirDanio(50);
		objetivo.aturdir(1);
		return msj;
	}
}