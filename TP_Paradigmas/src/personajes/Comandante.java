package personajes;

import hechizos.*;

public class Comandante extends Mortifago{
	public Comandante (String nombre) {
		super(150,3,nombre);
		agregarHechizo(new Expelliarmus());
		agregarHechizo(new AvadaKedavra());
	}
}
