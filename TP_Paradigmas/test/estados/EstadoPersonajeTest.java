package estados;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personajes.Auror;

class EstadoPersonajeTest {

	Auror a;
	
	@BeforeEach
	public void preparar(){
		a = new Auror("Harry");
	}
	
	@Test
    void sano_recibeDanioCompleto() {
        a.recibirDanio(30);
        assertEquals(120, a.getHp());
    }

    @Test
    void sano_puedeActuar() {   
        assertTrue(a.puedeActuar());
    }
    
    // Transición a Protegido

    @Test
    void protegido_noRecibeDanio() {
        a.proteger(1);                      // pasa a Protegido
        a.recibirDanio(40);
        assertEquals(150, a.getHp());        
    }

    @Test
    void protegido_vuelveASanoTrasAgotarDuracion() {
        a.proteger(1);                      
        a.recibirDanio(10);                 
        a.recibirDanio(10);                
        assertEquals(140, a.getHp());
    }

    //  Transición a Aturdido 

    @Test
    void aturdido_noPuedeActuar_porAturdimiento() {
        a.aturdir(1);
        assertFalse(a.puedeActuar());
    }
    
    @Test
    void aturdido_vuelve_a_actuar() {
        a.aturdir(1);
        assertFalse(a.puedeActuar());
        a.pasarTurno(1);
        assertTrue(a.puedeActuar());
    }

    //  Transición a Muerto

    @Test
    void muerto_cuandoHpLlegaACero() {
    	
        a.recibirDanio(150);                
        assertEquals(0, a.getHp());         
        assertFalse(a.puedeActuar());       
    }

    @Test
    void muerto_noRecibeMasDanio() {
        a.recibirDanio(150);                
        a.recibirDanio(50);                 
        assertEquals(0, a.getHp());         
    }
}
