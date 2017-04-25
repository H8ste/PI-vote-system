package dk.aau.pi.med2.nolse16.vote.system;

import java.net.*;
import java.io.*;

public class VotingServerThread extends Thread {
	private Socket socket = null;
	private String tempInCheck;

	public VotingServerThread(Socket socket) {
		super("MultiVotingServerThread");
		this.socket = socket;
	}

	public void run() {
		while (true) {
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String inputLine;
				if ((inputLine = in.readLine()) != null) {
					System.out.println(inputLine);

					// Load Polls
					if (inputLine.equals("loadPolls")) {
						String tempString = loadPolls();

						// ByteArrayOutputStream outToClient = new
						// ByteArrayOutputStream(socket.getOutputStream());
						DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
						// PrintWriter out = new
						// PrintWriter(socket.getOutputStream(), true);
						outToClient.writeBytes(tempString + "\n");
						System.out.println(outToClient);
						// out.writeBytes("sending from server");
						System.out.println("sent from server now");
					}

					// Create Polls
					else if (inputLine.substring(0, 7).equals("newPoll")) {
						String pollData = inputLine.substring(8);
						savePolls(pollData);
						DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
						// PrintWriter out = new
						// PrintWriter(socket.getOutputStream(), true);
						outToClient.writeBytes("Poll saved" + "\n");
						System.out.println(outToClient);
						// out.writeBytes("sending from server");
						System.out.println("sent from server now");
					}

					// Get results
					else if ((tempInCheck = inputLine.substring(0,11)).equals("get results")) {				
						String tempString = loadSpecificPoll(Integer.parseInt(inputLine.substring(12)));
						System.out.println("This is what is sent to the client:" + tempString);
						DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
						outToClient.writeBytes(tempString + "\n");
						System.out.println("sent from server now");
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String loadPolls() {
		String[] tempStringArray = PollClass.loadStrings("./polls.txt");
		String tempString = "";

		for (int i = 1; i < tempStringArray.length; i++) {
			if (i == tempStringArray.length - 1) {
				tempString += tempStringArray[i] + "\n";
			} else {
				tempString += tempStringArray[i] + ";";
			}
		}
		return tempString;
	}
	public String loadSpecificPoll(int specifiedPoll){
		String[] tempStringArray = PollClass.loadStrings("./polls.txt");
		String tempString = "";
		
		for (int i = 0; i < tempStringArray.length; i++) {
			if (i == specifiedPoll) {
				tempString = tempStringArray[i+1];
				System.out.println("found poll " + specifiedPoll);
			}
		}
		return tempString;
	}
	public void savePolls(String string) {
		try(  PrintWriter out = new PrintWriter( "./polls.txt" )  ){
		    out.println(string);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
}