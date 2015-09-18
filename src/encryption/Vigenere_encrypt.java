package encryption;

public class Vigenere_encrypt {

	public char[] vigEncrypt (char[] startArray, String key, boolean encrypt){

		int[] keyArray = new int[key.length()];		//array containing the integer values of the individual key chars
		char[] endArray = new char[startArray.length]; 	//array of encrypted (or decrypted) chars
		int [] startIntArray = new int [startArray.length]; //array of int values of the (un)encrypted chars
		int [] sumArray = new int [startArray.length];	//array of the sums of start + key values
		int keyPos = 0; //position of the current keyInteger inside the keyArray

		for (int i = 0; i < key.length(); i ++){ //convert the key string into an integer array
			keyArray[i] = key.charAt(i);
			keyArray[i] = keyArray[i] - 96;
		}
		for (int i = 0; i < startArray.length; i++){ //convert start Chars to start Ints
			startIntArray[i] = startArray[i] - 96;
			
		}
		System.out.print("before for");
		for(int i = 0; i < startArray.length; i++){ // as long as there are values to be encrypted
			if (keyPos >= (keyArray.length -1)){// circle through the keyword
				keyPos = 0;
			}

			if (encrypt){
			System.out.println(i);
				sumArray[i] = startIntArray[i] + keyArray[keyPos];
				
			} else {
				sumArray[i] = startIntArray[i] - keyArray[keyPos];
			}
			if (sumArray[i] < 0){
				sumArray[i] *= (-1);
			}
			
			if (sumArray[i] > 26){
				sumArray[i] = sumArray[i] % 26;
			}
			


			endArray[i] = (char) (sumArray[i] + 96);

			keyPos++;
		}

		return endArray;
	}

}
