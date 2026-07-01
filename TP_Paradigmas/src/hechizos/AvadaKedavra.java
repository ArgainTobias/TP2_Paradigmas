package hechizos;

import personajes.Personaje;

public class AvadaKedavra extends HechizoAtaque {
	@Override
	public String ejecutar(Personaje lanzador, Personaje objetivo) {
		
		String msj = lanzador.getNombre() + " lanza " + getClass().getSimpleName() + " a " + objetivo.getNombre();
		System.out.println(msj);
		objetivo.recibirDanio(objetivo.getHp()); //el avadaKedabra te mata de una
		return msj;
	}
	
	@Override
	public String toString() {
	    return getClass().getSimpleName();
	}
}
