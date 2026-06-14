package personajes;

import hechizos.Hechizo;
import java.util.List;
import java.util.ArrayList;

public abstract class Personaje{
	
	private int hp,lvl;
	private String nombre;
	private List <Hechizo> hechizos = new ArrayList<>();
//	private double xDanio,xCura;
	
	public Personaje(int hp, int lvl, String nombre) {
		this.hp = hp;
		this.lvl = lvl;
		this.nombre = nombre;
//		this.xCura =1.0;
//		this.xDanio = 1.0;
	}
	
	public void agregarHechizo(Hechizo h) {
		hechizos.add(h);
	}
	
	public void lanzarHechizo(Hechizo h,Personaje objetivo) {
		h.ejecutar(this, objetivo);
	}
	
//	public double multiplicadorDanio() {
//        return 1.0;
//    }

	public void recibirDanio(int valor) {
		hp-=valor;
		if(hp<0) {
			hp=0;
		}
	}
	
	public int getHp() {
		return hp;
	}
	
	public List<Hechizo> getHechizos() {
	    return hechizos;
	}
	
	@Override
	public String toString() {
	    return nombre + " (" + getClass().getSimpleName() + ") [HP: " + hp + ", Nivel: " + lvl + ", Hechizos: " + hechizos.size() + "]";
	}	
	
}
