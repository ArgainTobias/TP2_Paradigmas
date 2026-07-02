package hechizos;

import personajes.Personaje;

public class Expelliarmus extends HechizoAtaque{
	
	 @Override
	public String ejecutar(Personaje lanzador, Personaje objetivo) {
		String msj = lanzador.getNombre() + " lanza " + getClass().getSimpleName() + " a " + objetivo.getNombre();
		System.out.println(msj);
		objetivo.recibirDanio(10*lanzador.getLvl());
		return msj;
	}
	 
	 @Override
		public String toString() {
		    return getClass().getSimpleName();
		}
}
