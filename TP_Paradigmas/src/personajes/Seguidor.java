package personajes;
import hechizos.*;

public class Seguidor extends Mortifago{
	public Seguidor (String nombre) {
		super(80,1,nombre);
		agregarHechizo(new Expelliarmus());
	}
}