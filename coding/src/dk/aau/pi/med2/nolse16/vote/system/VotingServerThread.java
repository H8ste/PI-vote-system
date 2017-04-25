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
					if (inputLine.substring(0, 7).equals("newPoll")) {
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
					if (inputLine.substring(0,11).equals("get results")) {
						System.out.println("get results + some shit arrived to server");
						String tempString = loadSpecificPoll(Integer.parseInt(inputLine.substring(12)));
						
						DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
						// PrintWriter out = new
						// PrintWriter(socket.getOutputStream(), true);
						outToClient.writeBytes("This is what is sent from the server kappa" + "\n");
						System.out.println(outToClient);
						// out.writeBytes("sending from server");
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

		for (int i = 0; i < tempStringArray.length; i++) {
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
				
			}
			if (i == tempStringArray.length - 1) {
				tempString += tempStringArray[i] + "\n";
			} else {
				tempString += tempStringArray[i] + ";";
			}
		}
		return null;
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