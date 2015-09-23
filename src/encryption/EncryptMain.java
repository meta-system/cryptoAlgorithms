package encryption;

public class EncryptMain {
	
	private static String pText = "So gut, Herr Nelles?!";
	
	public static void main(String[] args) {
		
		EncryptAlgorithms myCaesar = new EncryptAlgorithms();	//neues Objekt der Klasse EncryptAlgorithms
		
		String cryptText = myCaesar.cesarEncrypt(pText, 3, true);	//die caesarEncrypt Funktion wird aufgerufen
		System.out.println("Encrypted Text: " +cryptText);
		
		cryptText = myCaesar.cesarEncrypt(cryptText, 3, false);
		System.out.println("Decrypted Text: " +cryptText);

	}

}
