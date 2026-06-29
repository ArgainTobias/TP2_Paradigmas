package personajes;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;

import hechizos.Hechizo;

public class Batallon{
	
	//4. Gestion de batallones
	Set<Personaje> setBatallon;
	List<Personaje> setSecuencia;
	Map<Personaje,Hechizo> mapHechizosPersonaje;
	Set<Hechizo> hechizosPorTurno;
	
	public Batallon() {
		setBatallon = new HashSet<>();
	}
	
	public void agregarPersonaje(Personaje personaje) {
		setBatallon.add(personaje);   
	}
	
	public void mostrarBatallon() {
		for(Personaje personaje : setBatallon){
			
			System.out.println(personaje);
			for(Hechizo hechizo : personaje.getHechizos()) {
				System.out.println("Hechizos disponibles:"+ hechizo);
			}
			
		}
	}
	
	public int getCantSoldados() {
		return setBatallon.size();
	}
	
	public boolean tienePersonajesSaludables() {
		
		for(Personaje personaje : setBatallon){
			if(personaje.getHp()>0) {
				return true;
			}
		}
		return false;
	}
	
	public void asignarHechizosAtaque  () {
		
	}
	
}
