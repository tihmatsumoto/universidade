package servidorHash;

import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class cliente {
	public static void main(String[] args) throws UnknownHostException, IOException, NoSuchAlgorithmException {
		
		Socket conServidor = new Socket("localhost", 12345);

		Scanner lerDoTeclado = new Scanner(System.in);
		System.out.println("Digite o número da frase: ");
		int opcao = lerDoTeclado.nextInt();
		
		PrintStream escreverNoServidor = new PrintStream(conServidor.getOutputStream());
		escreverNoServidor.println(opcao);
		
		Scanner ouvirOServidor = new Scanner(conServidor.getInputStream());
		
		String resp = ouvirOServidor.nextLine();
		
		String hash = ouvirOServidor.nextLine();
		
		System.out.println(hash);
				
		MessageDigest algoritmo = MessageDigest.getInstance("md5");
		
		algoritmo.update(resp.getBytes(), 0, resp.length());
	
		String hashResp = (new BigInteger(1, algoritmo.digest()).toString(16));
		
		if (hash.equals(hashResp)) {
			System.out.println(resp);
			
		} else {
			System.out.println("Mensagem corrompida!");
			
		}
		
		
		conServidor.close();
		
		
		
	}
}







