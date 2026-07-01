package personajes;

import hechizos.*;

public class Estudiante extends Mago{
	public Estudiante (String nombre) {
		super(80,1,nombre);
		agregarHechizo(new Expelliarmus());
	}
}