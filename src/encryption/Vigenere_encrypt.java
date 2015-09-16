package encryption;

public class Vigenere_encrypt {

	public char[] vigEncrypt (char[] startArray, String key, boolean encrypt){

		int[] keyArray = new int[key.length()];
		char[] endArray = new char[startArray.length]; 
		int [] startIntArray = new int [startArray.length];
		int [] sumArray = new int [startArray.length];
		
		for (int i = 0; i < key.length(); i ++){
			keyArray[i] = key.charAt(i);
			keyArray[i] = keyArray[i] - 97;
		}
		for (int i = 0; i < startArray.length; i++){
			startIntArray[i] = startArray[i];
		}

		for(int i = 0; i < startArray.length; i++){
			for (int j = 0; j < keyArray.length; j++){
				if (encrypt){
					sumArray[i] = (keyArray[j] + startIntArray[i]);
					while (sumArray[i] > 122){
						sumArray[i] = (sumArray[i] - 122) + 97;
					}
				} else {
					sumArray[i] = (keyArray[j] + startIntArray[i]);
					while (sumArray[i] < 97){
						sumArray[i] = 122 - (97 - sumArray[i]);
					}
				}

			}
			endArray[i] = (char) sumArray[i];
		}


		return endArray;
	}

}
