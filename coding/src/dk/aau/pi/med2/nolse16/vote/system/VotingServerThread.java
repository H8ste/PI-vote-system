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
//				System.out.println("Reading request from client now. Give me a second");
//				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

				String inputLine;
				if ((inputLine = in.readLine()) != null) {
					System.out.println(inputLine);
					if (inputLine.equals("test")){
						DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
//						PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
						outToClient.writeBytes("This is what is sent from the server kappa" + "\n");
						System.out.println(outToClient);
//						out.writeBytes("sending from server");
						System.out.println("sent from server now");
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void loadPolls() {
		
	}
}