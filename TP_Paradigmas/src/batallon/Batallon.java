package batallon;
 
import java.util.*;
 
import hechizos.Hechizo;
import personajes.Personaje;
 
public class Batallon {
	protected Set<Personaje> personajes;
	protected List<String> secuenciaAcciones; //Ver que tipo de dato contiene la lista (puede quedar string creo) 
	protected Map<Personaje, ArrayList<Hechizo>> hechizosLanzados;
	protected Set<Hechizo> lanzadosTurno;
	public Batallon() {
		this.personajes = new HashSet<Personaje>();
		this.secuenciaAcciones = new ArrayList<String>();
		this.hechizosLanzados = new HashMap<Personaje, ArrayList<Hechizo>>();
		this.lanzadosTurno = new HashSet<Hechizo>();
	}
	public void agregarPersonaje(Personaje p) {
		this.personajes.add(p);
		this.hechizosLanzados.put(p, new ArrayList<Hechizo>());
	}
	public boolean tienePersonajesSaludables() {
		for(Personaje p : this.personajes) {
			if(p.getHp()>0) {
				return true;
			}
		}
		return false;
	}
	public void atacar(Batallon objetivo) {
		lanzadosTurno.clear(); //vacio el set porque empieza el turno
		Random rand = new Random();
		List<Personaje> personajesObjetivo = objetivo.getPersonajesSaludables();
		int cantObjetivo =  personajesObjetivo.size();
		for (Personaje p : personajes) {
			int indiceObjetivo = rand.nextInt(cantObjetivo);
			Hechizo hechizo = elegirHechizoDisponible(p);
			p.lanzarHechizo(hechizo, personajesObjetivo.get(indiceObjetivo));
			secuenciaAcciones.add(p.getNombre() + " lanza " + hechizo + " a " + personajesObjetivo.get(indiceObjetivo).getNombre());
			System.out.println(p.getNombre() + " lanza " + hechizo + " a " + personajesObjetivo.get(indiceObjetivo).getNombre());
			ArrayList<Hechizo> lanzados = hechizosLanzados.get(p);
			if(hechizo != null)
			{
				lanzados.add(hechizo);
				hechizosLanzados.put(p, lanzados); //agrego a la lista de lanzados del personaje
				lanzadosTurno.add(hechizo); //agrego al set de los lanzados en este turno					
			}
		}
	}

	public List<Personaje> getPersonajesSaludables(){
		List<Personaje> saludables = new ArrayList<Personaje>();
		for(Personaje p : this.personajes) {
			if(p.getHp()>0) {
				saludables.add(p);
			}
		}
		return saludables;
	}
	private Hechizo elegirHechizoDisponible(Personaje p) {
        
        for(Hechizo h : p.getHechizos()) {
        	
        	if(!lanzadosTurno.contains(h)) {
        		return h;
        	}
        	
        }

        return null;
    }
 
	
	public void mostrarBatallon() {
		for(Personaje personaje : personajes){
			
			System.out.println(personaje);
			for(Hechizo hechizo : personaje.getHechizos()) {
				System.out.println("-> Hechizos disponibles del personaje: "+ hechizo);
			}
			
		}
	}
	
	public int getCantSoldados() {
		return personajes.size();
	}
	
}
