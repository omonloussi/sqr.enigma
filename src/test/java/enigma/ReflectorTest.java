package enigma;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReflectorTest {

	int p = 1;
	
	@Test
	public void test() {
		Reflector ref = new Reflector();
		int expected = p;
		int actual = ref.convertForward(p);
		assertNotSame(expected,actual);
	} 

}
  

