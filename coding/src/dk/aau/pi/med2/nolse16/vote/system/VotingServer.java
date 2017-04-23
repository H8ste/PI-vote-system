package dk.aau.pi.med2.nolse16.vote.system;

import java.io.IOException;

public class VotingServer {
	public static void main(String[] args) throws IOException {
		try {
			while (true) {
				VotingServerThread t = new VotingServerThread();
				t.start();
				t.join();
			}
		} catch (InterruptedException e) {
			return;
		}
	}
}
