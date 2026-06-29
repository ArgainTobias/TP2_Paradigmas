package personajes;

import hechizos.Hechizo;
import java.util.List;
import java.util.ArrayList;
import estados.EstadoPersonaje;
import estados.Sano;

public abstract class Personaje{
	
	private int hp,lvl;
	private String nombre;
	private List <Hechizo> hechizos = new ArrayList<>();
	private EstadoPersonaje estado;
	
	public Personaje(int hp, int lvl, String nombre) {
		this.hp = hp;
		this.lvl = lvl;
		this.nombre = nombre;
		estado = new Sano();
	}
	// GETTERS Y SETTERS PERSONAJE

	public void reducirHp(int valor) {
		hp-=valor;
		if(hp<0) {
			hp=0;
		}
	}
	
	public int getHp() {
		return hp;
	}
	
	//PRIMITIVAS ESTADOS
	
	public void recibirDanio(int danio) {
		this.estado=estado.recibirDanio(this, danio);
	}
	
	public void proteger(int duracion) {
	    this.estado = estado.proteger(duracion);
	}

	public void aturdir(int duracion) {
	    this.estado = estado.aturdir(duracion);
	}
	
	public boolean puedeActuar() {
		return estado.puedeActuar();
	}
	
	//PRIMITIVAS DE HECHIZOS
	
	public void agregarHechizo(Hechizo h) {
		hechizos.add(h);
	}
	
	public void lanzarHechizo(Hechizo h,Personaje objetivo) {
		h.ejecutar(this, objetivo);
	}
	

	
	public List<Hechizo> getHechizos() {
	    return hechizos;
	}
	
	@Override
	public String toString() {
	    return nombre + " (" + getClass().getSimpleName() + ") [HP: " + hp + ", Nivel: " + lvl + ", Hechizos: " + hechizos.size() +"|"+ estado.getClass().getSimpleName()+"]";
	}	
	
}
