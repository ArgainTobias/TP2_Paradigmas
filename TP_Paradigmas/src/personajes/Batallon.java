package personajes;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
				System.out.println("-> Hechizos disponibles del personaje: "+ hechizo);
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
	
	public void atacar (Batallon batallonEnemigo) {
		Hechizo hechizoUsado;
		 for (Personaje aliado: setBatallon) {
			for(Personaje enemigo: batallonEnemigo.setBatallon) {
				//hechizoUsado=
				if(enemigo.getHp() > 0) { //si esta vivo -- calculo que lo puedo hacer con el state
					aliado.lanzarHechizo(null, enemigo);
					System.out.println(aliado.getNombre() + "ataco a "+ enemigo.getNombre());
				}
			}
				
			 
		}
	}
	
	public void asignarHechizosAtaque  () {
		
	}
	
}
