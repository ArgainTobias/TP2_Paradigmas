package personajes;

import hechizos.*;

public class Profesor extends Mago{
	public Profesor (String nombre) {
		super(100,2,nombre,100);
		agregarHechizo(new Protego());
		agregarHechizo(new Expelliarmus());
	}
}
