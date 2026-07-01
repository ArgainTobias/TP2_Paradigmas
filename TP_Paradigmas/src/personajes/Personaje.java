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
	
	public int getLvl() {
		return lvl;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public EstadoPersonaje getEstado() {
		
		return estado;
	}
	
	//PRIMITIVAS ESTADOS
	
	public void recibirDanio(int danio) {
		this.estado=estado.recibirDanio(this, danio*lvl);
	}
	
	public void proteger(int duracion) {
	    this.estado = estado.proteger(this, duracion);
	}

	public void aturdir(int duracion) {
	    this.estado = estado.aturdir(this, duracion);
	}
	
	public boolean puedeActuar() {
		return estado.puedeActuar();
	}
	
	public boolean puedeSerObjetivo() {
		return estado.puedeSerObjetivo();
	}
	
	//PRIMITIVAS DE HECHIZOS
	
	public void agregarHechizo(Hechizo h) {
		hechizos.add(h);
	}
	
	public String lanzarHechizo(Hechizo h,Personaje objetivo) {
		return h.ejecutar(this, objetivo);
	}
	

	
	public List<Hechizo> getHechizos() {
	    return hechizos;
	}
	
	@Override
	public String toString() {
	    return nombre + " (" + getClass().getSimpleName() + ") [HP: " + hp + ", Nivel: " + lvl + ", Hechizos: " + hechizos.size() + "]";
	}	
	
	//COMPARACION, HASH Y EQUALS PARA EL SET DE BATALLON
	
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof Personaje)) {
			return false;
		}
		Personaje otroPersonaje = (Personaje) obj;
		return this.nombre.equals(otroPersonaje.nombre);
	}
	
	@Override
	public int hashCode() {
		return java.util.Objects.hash(nombre);
	}
}
