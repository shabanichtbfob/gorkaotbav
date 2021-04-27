package testt;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import LN.clsNivel;

public class clsNivelTest {

	clsNivel n;
	
	@Before
	public void setUp() throws Exception {
		n = new clsNivel();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testfilaNivel() {
		
		@SuppressWarnings("static-access")
		int num1 = n.filaNivel(1);  //eman behar digu 3
		
		int num2 = 3;
		
		assertEquals(num1, num2);
		
	}

}
