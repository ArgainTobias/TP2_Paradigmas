package batallon;

import java.util.*;

import hechizos.Hechizo;
import personajes.Personaje;

public class Batallon {
	protected Set<Personaje> personajes;
	protected List<String> secuenciaAcciones; // Ver que tipo de dato contiene la lista (puede quedar string creo)
	protected Map<Personaje, ArrayList<Hechizo>> hechizosLanzados;
	protected Set<Hechizo> lanzadosTurno;

	public Batallon() {
		this.personajes = new HashSet<Personaje>();
		this.secuenciaAcciones = new ArrayList<String>();
		this.hechizosLanzados = new HashMap<Personaje, ArrayList<Hechizo>>();
		this.lanzadosTurno = new HashSet<Hechizo>();
	}
	
	public List<Personaje> getPersonajes() {
	    return new ArrayList<>(personajes);
	}

	public void agregarPersonaje(Personaje p) {
		this.personajes.add(p);
		this.hechizosLanzados.put(p, new ArrayList<Hechizo>());
	}

	public boolean tienePersonajesSaludables() {
		for (Personaje p : this.personajes) {
			if (p.getHp() > 0) {
				return true;
			}
		}
		return false;
	}

	public String atacar(Batallon objetivo) {
		StringBuilder log = new StringBuilder();
		String aux;
		lanzadosTurno.clear(); // vacio el set porque empieza el turno
		for (Personaje p : personajes) {

			if (p.puedeActuar()) {
				Hechizo hechizo = elegirHechizoDisponible(p);
				if (hechizo != null) {
					Personaje obj = hechizo.seleccionarObjetivo(p, this, objetivo);
					if (obj != null) {
						aux= p.lanzarHechizo(hechizo, obj);
						log.append(aux).append("\n");
						secuenciaAcciones.add(aux);
						ArrayList<Hechizo> lanzados = hechizosLanzados.get(p);
						lanzados.add(hechizo);
						hechizosLanzados.put(p, lanzados); // agrego a la lista de lanzados del personaje
						lanzadosTurno.add(hechizo); // agrego al set de los lanzados en este turno
					}
				} else {
					log.append(p.getNombre() + " no tiene hechizos disponibles para lanzar este turno").append("\n");
				}
			} else {
				if(p.getHp() >0) {
					log.append(p.getNombre() +" ("+ p.getHp()+" HP) pierde su turno porque esta " + p.getEstado().getClass().getSimpleName()).append("\n");
					p.pasarTurno(1);
				}	
			}
			
		}
		return log.toString();

	}

	public List<Personaje> getPersonajesSaludables() {
		List<Personaje> saludables = new ArrayList<Personaje>();
		for (Personaje p : this.personajes) {
			if (p.getHp() > 0) {
				saludables.add(p);
			}
		}
		return saludables;
	}
	
	public void mostrarSecuencia() {
		for (String string : secuenciaAcciones) {
			System.out.println(string);
		}
	}

	private Hechizo elegirHechizoDisponible(Personaje p) {
	    List<Hechizo> copia = new ArrayList<>(p.getHechizos());
	    Collections.shuffle(copia);
	    for (Hechizo h : copia) {
	        if (!lanzadosTurno.contains(h)) {
	            return h;
	        }
	    }
	    return null;
	}

	public void mostrarBatallon() {
		for (Personaje personaje : personajes) {

			System.out.println(personaje);
			System.out.println("-> Hechizos disponibles del personaje: " + personaje.getHechizos());

		}
	}

	public int getCantSoldados() {
		return personajes.size();
	}

}
