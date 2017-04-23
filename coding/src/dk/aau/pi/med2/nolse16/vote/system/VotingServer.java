package dk.aau.pi.med2.nolse16.vote.system;

import java.net.*;
import java.io.*;
public class VotingServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        boolean listening = true;

        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(-1);
        }

        while (listening)
        new VotingServerThread(serverSocket.accept()).start();

        serverSocket.close();
    }
}


