package enigma;

/** Class that represents a reflector in the enigma.
 *  @author
 */

//Refletor class is an child class for Rotor class
public class Reflector extends Rotor {
	
	int[] reflection;
	
	//Return the cipher letter equal to the string passing in the function
	public static Reflector reflectorFactory(String str){
		char[] s = str.trim().replace(" ", "").toCharArray();
		int[] cipher = new int[26];
		for (int i = 0; i< 26; i++){ 
			cipher[i] = toIndex(s[i]);
		}
		return new Reflector(cipher);
	}
	
	//Constructeur pour effectuer des tests sur la classe Reflector avec un constructeur vide et moins complexe
	public Reflector() {
		super();
		reflection = null; 
	}
	
	private Reflector(int[] r){
		reflection = r;
	}
      
	//Convert Forward the rotor around 26 letters by giving a position
    public int convertForward(int p) {
        return ((reflection[((p)%26+26)%26])%26+26)%26;
    }

    @Override
    public int convertBackward(int unused) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void advance() {
    }

}
