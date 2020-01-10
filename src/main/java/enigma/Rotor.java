package enigma;

public class Rotor {

	
    private int position;
    private int[] cipher = new int[26];
    private int[] bcipher = new int[26];
    private int notch1 = -1;
    private int notch2 = -1;

    //Return the position of rotor
    public int getPosition() {
        return position;
    }

    //Set the position of rotor
    public void setPosition(int posn) {
        position = posn;
    }
    
    
	public static Rotor rotorFactory(String str, String notches){
		char[] s = str.trim().replace(" ", "").toCharArray();
		int[] cipher = new int[26];
		for (int i = 0; i< 26; i++){
			cipher[i] = toIndex(s[i]);
		}
		s = notches.trim().replace(" and ", "").toCharArray();
		if (s.length == 2){
			return new Rotor(cipher, toIndex(s[0]), toIndex(s[1]));
		} else {
			return new Rotor(cipher, toIndex(s[0]));
		}
		
	}
	
	
	private Rotor(int[] c, int notch1, int notch2) {
		this.notch1 = notch1;
		this.notch2 = notch2;
		cipher = c;
		createBCipher();
	}
	
	private Rotor(int[] c, int notch1) {
		this.notch1 = notch1;
		cipher = c;
		createBCipher();
	}
	
	protected Rotor() {
		
	}
	
	//convert forward the rotor by giving an position
    public int convertForward(int p) {
        return ((cipher[((p+position)%26+26)%26]-position)%26+26)%26;
    }
    
  //convert backward the rotor by giving an position
    public int convertBackward(int e) {
        return ((bcipher[((e+position)%26+26)%26]-position)%26+26)%26;
    }
    
    //To advance the rotor around 26 letter
    public void advance() {
        position = (position+1) % 26;
    }
    
    protected boolean atNotch() {
        return (position == notch1 || position == notch2);
    }

    protected static char toLetter(int p) {
        return (char)(p + 'A');
    }

    protected static int toIndex(char c) {
        return c - 'A';
    }
    
	private void createBCipher() {
		for(int i =0; i<26; i++)
			bcipher[cipher[i]] = i;
	}



}
