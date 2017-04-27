package com.example.christian.pollvotingsoftware;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Main_Menu extends AppCompatActivity {

    public Button connect;
    public InetAddress IP;
    public Socket clientSocket;
    public DataOutputStream outToServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__menu);

        connect = (Button)  findViewById(R.id.connect);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void connectToServer(View view) {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    try {
                        IP = InetAddress.getByName("10.0.2.2");
                        clientSocket = new Socket(IP, 4445);
                        Log.d("Servertesting","creates socket");
                        outToServer = new DataOutputStream(clientSocket.getOutputStream());
                        Log.d("Servertesting","establishes outputstream");
//                        outToServer.writeBytes(sentence + "\n");
//                        Log.d("SENT", "Message is sent to server");
//
//                        //waits and read input from, maybe not necessary in all cases
//                        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//                        Log.d("From server", "received shit from server");
//                        //modified sentence == results from server
//                        modifiedSentence = inFromServer.readLine();
//                        Log.d("From server", modifiedSentence);
//                        clientSocket.close();
//                        outToServer.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //Your code goes here
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
//        try {
//            thread.join();
//            Log.d("finishthread", "thread ends");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }




        //Goes to class called ViewPolls
        Intent i = new Intent(Main_Menu.this, Poll_Overview.class);
        startActivity(i);
    }
}