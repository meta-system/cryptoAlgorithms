package encryption;

import java.util.Arrays;

public class EncryptMain {
	
	private static char [] plainText = {'b','r','u','c','e','s','c','h','n','e','i','e','r'};
	private static String key = "licht";
	
	
	
	public static void main(String[] args) {
		
		Caesar_encrypt myCaesar = new Caesar_encrypt();
		
		char[] cryptText = myCaesar.cesarEncrypt(plainText, 3, true);
		System.out.println("Encrypted Text: " +Arrays.toString(cryptText));
		
		cryptText = myCaesar.cesarEncrypt(cryptText, 3, false);
		System.out.println("Decrypted Text: " +Arrays.toString(cryptText));
		
		Vigenere_encrypt myVigenere = new Vigenere_encrypt();
		
		cryptText = myVigenere.vigEncrypt(plainText, key, true);
		System.out.println("Decrypted Text: " +Arrays.toString(cryptText));
		cryptText = myVigenere.vigEncrypt(plainText, key, false);
		System.out.println("Decrypted Text: " +Arrays.toString(cryptText));
	}

}
