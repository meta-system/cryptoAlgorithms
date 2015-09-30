package encryption;

import java.util.Scanner;

public class EncryptMain {

	public static Scanner myScanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Bitte geben Sie den zu ent- oder verschluesselnden Text ein!");
		
		//Variablendeklariation
		String myText = myScanner.nextLine();
		boolean keyAvailable = false;
		int key = 0;
		String vigKey = "";
		String cryptText = "";
		
		int myAlgorithm = input("Wollen Sie mit" //Auswahl der Verschlüsselungsmethode
				+"\n [1] Caesar oder"
				+"\n [2] Vigenere arbeiten?"
				+"\n Bitte geben Sie den entsprechenden Integer ein!");
		
		boolean encrypt = (input("Wollen Sie"
				+"\n [0] entschluesseln oder"
				+"\n [1] verschluesseln?") != 0);
		
		if(encrypt){
			if(myAlgorithm == 1){
				key = (input("Bitte geben Sie den Verschiebungsfaktor ein!"));
				cryptText = EncryptAlgorithms.cesarEncrypt(myText, key, encrypt);
			} else if(myAlgorithm ==2){
				System.out.print("Bitte geben Sie den Schluessel ein(Wort, kurzer Text)!");
				vigKey = myScanner.nextLine();
				cryptText = EncryptAlgorithms.vigenereEncrypt(myText, vigKey, encrypt);
			}
		}
		
		else if(!encrypt){
			if(myAlgorithm == 1){
				keyAvailable = (input("Haben Sie einen Verschiebungsfaktor?\n [0|1]:[Ja|Nein]:\n(Entschlüsseln ohne Schlüssel funktioniert erst ab einer gewissen Textlänge)") != 0);
				if (keyAvailable){
					key = (input("Bitte geben Sie den Verschiebungsfaktor ein!")); 
				} else{
					key = cryptoAnalysis.caesarGetKey(myText);
					System.out.printf("Der Faktor des Schluesseltextes ist %d.%n", key);
				}
				cryptText = EncryptAlgorithms.cesarEncrypt(myText, key, encrypt);
			} else if(myAlgorithm == 2){
				System.out.print("Bitte geben Sie den Schluessel ein(Wort, kurzer Text)!");
				vigKey = myScanner.nextLine();
				cryptText = EncryptAlgorithms.vigenereEncrypt(myText, vigKey, encrypt);
			}
		}
		
		System.out.printf("Der ent- bzw. verschluesselte Text lautet:'%s'.%n",cryptText);
	}
	
	public static int input(String message) {
		int input = 0;
		boolean error = false;

		do {
			try {

				System.out.println(message);
				error = false;

				input = Integer.parseInt(myScanner.nextLine());

			} catch (NumberFormatException e) {//fängt ab, wenn kein Integer eingegeben wurde
				error = true;
				System.out.println("Fehlerhafte Eingabe!");
			}
		} while (error);

		return input;
	}
}
