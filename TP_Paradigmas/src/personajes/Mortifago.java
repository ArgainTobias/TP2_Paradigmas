package personajes;

public abstract class Mortifago extends Personaje{
	public double modificarDanio = 1.5;
	public Mortifago(int hp,int lvl,String nombre) {
		super(hp,lvl,nombre);
	}
}
