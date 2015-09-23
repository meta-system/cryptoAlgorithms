package encryption;

public class EncryptAlgorithms {
	
	//Caesar-Algorithmus;
	//Ver- oder entschl�sselt einen String mit einem integer nach dem Caesar-Verfahren
	public String cesarEncrypt(String startText, int key, boolean encrypt) {
		char[] sArray = startText.toCharArray();
		char[] eArray = new char[sArray.length];
		
		if (!encrypt){  //wenn der Boolean encrypt "false" ist:
			key *= (-1);
		}
		for (int i = 0; i < sArray.length; i++){
			eArray[i] = crypt(sArray[i], key);
		}
		
		return new String(eArray);
	}
	
	//Vigenere-Algorithmus;
	//Ver- oder entschl�sselt einen String mit einem Schl�sselstring nach dem Vigenere-Verfahren
	public String vigenereEncrypt(String startText, String key, boolean encrypt){
		//Array- und Variablendeklaration
		char[] sArray = startText.toCharArray();
		char[] eArray = new char[sArray.length];
		char[] kCArray = key.toCharArray();
		int[] kArray = new int[kCArray.length];
		int keyPos = 0;
		
		for (int i = 0; i < kCArray.length; i++){
			kArray[i] = (int) kCArray[i];
		}
		
		//wandle den (Buchstaben-)Schl�sselarray zu einem nutzbaren Int-Array um
		for (int i = 0; i < kArray.length; i++){
			if ((64 < kArray[i])&&(kArray[i] < 91)){
				kArray[i] -= 65;
			} else if ((96 < kArray[i])&&(kArray[i] < 123)){
				kArray[i] -= 97;
			} else {//hier wurde eine fehlerhafte Eingabe getätigt.
				kArray[i] = 0;	//also wird nur mit a verschlüsselt.
			}
			if (!encrypt){
				kArray[i] *= (-1);
			}
		}
		
		//gehe alle �bergebenen Elemente nacheinander durch
		for (int i = 0; i < sArray.length; i++){
			if (keyPos >= (kArray.length - 1)){//geh den Key-Array durch
				keyPos = 0;
			}
			eArray[i] = crypt(sArray[i], kArray[keyPos]);
			keyPos++;
		}
		
		return new String(eArray);
	}
	
	//verschl�sselt einen Buchstaben,
	//indem er ihn um einen Integer von Stellen im Alphabet verschiebt
	public char crypt(char startC, int key){
		//Variablendeklaration:
		int pInt = startC;
		int endInt = 0;
		
		
		//F�hre jeweils die shift- Funktion aus
		if ((64 < pInt)&&(pInt < 91)){	//wenn im Bereich der Gro�buchstaben, ziehe den Wert von "A" ab
			pInt -= 65;
			endInt = shift(pInt, key) + 65;
		} else if ((96 < pInt)&&(pInt < 123)){ //wenn im Bereich der Kleinbuchstaben, ziehe den Wert von "a" ab
			pInt -= 97;
			endInt = shift(pInt, key) + 97;
		} else {
			return startC; //wenn weder Gro�- noch Kleinbuchstabe, gib den Buchstaben direkt zur�ck
		}
		return (char) endInt; //gib den zu einem Buchstaben verwandelten Int zur�ck
	}

	//verschiebt einen Integer pInt um key Anzahl an Stellen
	public int shift(int pInt, int key){
		int cInt = 0;
		
		cInt = pInt + key;

		if (cInt < -26){ //cInt auf einen Bereich zwischen -26 und 0 legen, falls niedriger
			cInt %= 26;
		}
		if (cInt < 0){	//falls cInt < 0, addiere 26. Dadurch wird ein Wert zwischen 0 und 26 erzeugt
			cInt += 26;
		}
			
		if (cInt > 26){ //falls cInt > 26, rechne Modulo 26.
			cInt %= 26;
		}
		return cInt;	//gib cInt zur�ck
	}

}
