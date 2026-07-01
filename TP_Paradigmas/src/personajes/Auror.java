package personajes;

import hechizos.*;

public class Auror extends Mago {
	public Auror(String nombre) {
		super(150,3,nombre);
		agregarHechizo(new Protego());
		agregarHechizo(new ExpectoPatronum());
		agregarHechizo(new Expelliarmus());		
	}
	
}
