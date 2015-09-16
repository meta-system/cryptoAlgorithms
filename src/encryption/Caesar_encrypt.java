package encryption;

public class Caesar_encrypt {

	
	public char[] cesarEncrypt(char[] startText, int key, boolean encrypt) {
		char[] endText = new char[startText.length];
		int pInt, cInt;
		char pChar, cChar;
		for (int i = 0; i < startText.length; i++){
			pChar = startText[i];
			pInt = pChar;
			if (encrypt){
				cInt = pInt + key;
			} else {
				cInt = pInt - key;	
			}
			cChar = (char) cInt;
			endText[i] = cChar;
		}
		return endText;
		
	}

}
