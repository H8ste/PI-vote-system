package dk.aau.pi.med2.nolse16.vote.system;

import java.net.*;
import java.io.*;

public class VotingServerThread extends Thread {
	private Socket socket = null;

	public VotingServerThread(Socket socket) {
		super("MultiVotingServerThread");
		this.socket = socket;
	}

	public void run() {
		while (true) {
			// System.out.println("it's running this thread yup yup");
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

				String inputLine, outputLine;
				if ((inputLine = in.readLine()) != null) {
					System.out.println(inputLine);
					if (inputLine.equals("test")){
						System.out.println("recieving");
					}
					
//					while ((inputLine = in.readLine()) != null) {
//						if (inputLine == "test") {
//							out.println("THISWORKS");
//							out.write("THISWORKS");
//							// System.out.println("TESTING WORKS");
//						}
//					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			// try {
			// PrintWriter out = new PrintWriter(socket.getOutputStream(),
			// true);
			// BufferedReader in = new BufferedReader(new
			// InputStreamReader(socket.getInputStream()));
			//
			// String inputLine, outputLine;
			// // KnockKnockProtocol kkp = new KnockKnockProtocol();
			// // outputLine = kkp.processInput(null);
			// out.println(outputLine);
			//
			// while ((inputLine = in.readLine()) != null) {
			// outputLine = kkp.processInput(inputLine);
			// out.println(outputLine);
			// if (outputLine.equals("Bye"))
			// break;
			// }
			// out.close();
			// in.close();
			// socket.close();
			//
			// } catch (IOException e) {
			// e.printStackTrace();
			// }
		}
	}
	public void loadPolls() {
		
	}
}