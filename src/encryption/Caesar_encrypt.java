package encryption;

public class Caesar_encrypt {


	public char[] cesarEncrypt(char[] startText, int key, boolean encrypt) {
		char[] endText = new char[startText.length]; //deklariert ein neues Array, das genau so lang ist wie das übergebene Array
		int pInt, cInt;	//deklariert zwei neue integer
		char pChar, cChar; //deklariert zwei neue chars
		//die variablen - paare oben sind jeweils für die klar- bzw verschlüsselten Text
		for (int i = 0; i < startText.length; i++){
			pChar = startText[i];	//isoliere den aktuellen char aus dem array
			pInt = pChar - 97; //wandle ihn in seinen ascii-Wert um

			if (encrypt){
				cInt = pInt + key;

			} else {
				cInt = pInt - key;
			}

			if (cInt < -26){ //cInt auf einen Bereich zwischen -26 und 0 legen, falls niedriger
				cInt %= 26;
			}
			if (cInt < 0){	//falls cInt < 0, addiere 26. Dadurch wird ein Wert zwischen 0 und 26 erzeugt
				cInt += 26;
			}
			
			if (cInt > 26){
				cInt %= 26;
			}
			cInt += 97;
			// der Wert des Integers wird wahlweise nach rechts oder nach links verschoben (größer-kleiner), je nachdem, ob mit ihm ver- oder entschlüsselt werden soll
			cChar = (char) cInt; //der verschlüsselte int wird in einen char verwandelt
			endText[i] = cChar;	//der char wird der aktuellen Stelle im fertigen Array zugewiesen

		}

		return endText;	//das Programm gibt den fertigen Array zurück

	}

	static String caesar(String startText, int shift) {
		// Convert to char array.
		char[] buffer = startText.toCharArray();

		// Loop over characters.
		for (int i = 0; i < buffer.length; i++) {

			// Shift letter, moving back or forward 26 places if needed.
			char letter = buffer[i];
			letter = (char) (letter + shift);
			if (letter > 'z') {
				letter = (char) (letter - 26);
			} else if (letter < 'a') {
				letter = (char) (letter + 26);
			}
			buffer[i] = letter;
		}
		// Return final string.
		return new String(buffer);
	}

}
