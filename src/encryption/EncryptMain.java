package encryption;

import java.util.Scanner;

public class EncryptMain {

	public static void main(String[] args) {
		int myKey = 0;
		Scanner sc = new Scanner(System.in);
		String myText = sc.nextLine();
		int key = 3;

		String cryptText = EncryptAlgorithms.cesarEncrypt(myText, key, true);
		System.out.println("Encrypted Text: " + cryptText);

		myKey = cryptoAnalysis.caesarGetKey(cryptText);
		System.out.println(myKey);

		cryptText = EncryptAlgorithms.cesarEncrypt(cryptText, myKey, false);
		System.out.println("Decrypted Text: " + cryptText);

		sc.close();
	}

}
