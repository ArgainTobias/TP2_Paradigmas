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
		for (Personaje p : personajes) {
			
			if(p.puedeActuar())
			{
				Hechizo hechizo = elegirHechizoDisponible(p);
				if(hechizo != null)
				{
					Personaje obj = hechizo.seleccionarObjetivo(p, this, objetivo);
					if(obj != null) {
						
						secuenciaAcciones.add( p.lanzarHechizo(hechizo, obj));
						ArrayList<Hechizo> lanzados = hechizosLanzados.get(p);
						lanzados.add(hechizo);
						hechizosLanzados.put(p, lanzados); //agrego a la lista de lanzados del personaje
						lanzadosTurno.add(hechizo); //agrego al set de los lanzados en este turno					
					}
					
				}else {
					System.out.println(p.getNombre() + " no tiene hechizos disponibles para lanzar este turno");
				}	
				
			}
			else {
				System.out.println(p.getNombre() + " pierde su turno porque esta " + p.getEstado().getClass().getSimpleName());
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
