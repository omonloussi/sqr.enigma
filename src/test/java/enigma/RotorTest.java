package enigma;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotorTest {

	int pos1 = 1;
	int pos2 = 2;
	
	//Tester convertForward pour tester un Rotor initial
	@Test
	public void convert_Forward_Test() {
		Rotor r = new Rotor();
		int expected = pos1;
		int actual = r.convertForward(pos1);
		assertNotSame(expected,actual);
	}
	
	
	//Tester convertForward et convertBackward pour Rotor initial
	@Test
	public void convert_ForwardBackward_Test() {
		Rotor r = new Rotor();
		int expected = 0;
		int forw = r.convertForward(expected);
		int actual = r.convertBackward(forw);
		assertEquals(expected, actual);
	}

}
