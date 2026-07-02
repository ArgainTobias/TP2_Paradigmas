package hechizos;

import personajes.Personaje;

public class Anapneo extends HechizoAmistoso{

	@Override
	public String ejecutar(Personaje lanzador, Personaje objetivo) {
		String msj = lanzador.getNombre() + " cura usando " + getClass().getSimpleName() + " a " + objetivo.getNombre();
		System.out.println(msj);
		objetivo.recibirDanio(-20*lanzador.getLvl());
		return msj;
	}
	
	 @Override
		public String toString() {
		    return getClass().getSimpleName();
		}
	
}
