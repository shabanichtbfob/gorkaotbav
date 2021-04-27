package testt;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import LN.clsJugador;

public class clsJugadorTest extends TestCase{

	clsJugador j;
	
	@Before
	public void setUp() throws Exception {
		j = new clsJugador("aa", "sss", "rr", "tt");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testgetNombre() {
		
		String nombre = "aa";
		String nombre2 = j.getNombre();
		
		assertEquals(nombre, nombre2);
	}

}
