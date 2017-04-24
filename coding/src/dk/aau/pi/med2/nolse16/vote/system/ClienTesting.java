package dk.aau.pi.med2.nolse16.vote.system;

import java.io.*;
import java.net.*;

public class ClienTesting {
	public static void main(String argv[]) throws Exception {
		while (true) {
			String sentence;
			String modifiedSentence;
			BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
			Socket clientSocket = new Socket("localhost", 4445);
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			

			sentence = inFromUser.readLine();
			if (sentence.equals("test")) {
				outToServer.writeBytes(sentence + '\n');
				BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				System.out.println("readline is the issue");
				modifiedSentence = inFromServer.readLine();
				System.out.println(modifiedSentence);	
				System.out.println("reaches here");
			}
//			outToServer.writeBytes(sentence + '\n');
			// modifiedSentence = inFromServer.readLine();
			// System.out.println("FROM SERVER: " + modifiedSentence);
			clientSocket.close();
		}
	}
}