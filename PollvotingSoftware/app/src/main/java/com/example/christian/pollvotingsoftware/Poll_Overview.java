package com.example.christian.pollvotingsoftware;import android.content.Intent;import android.os.Bundle;import android.support.v7.app.AppCompatActivity;import android.util.Log;import android.view.View;import android.widget.Button;import android.widget.TableLayout;import android.widget.TableRow;import android.widget.TextView;import java.io.BufferedReader;import java.io.DataOutputStream;import java.io.IOException;import java.io.InputStreamReader;import java.net.InetAddress;import java.net.Socket;import static android.R.id.button1;import static android.os.Build.VERSION_CODES.M;import static com.example.christian.pollvotingsoftware.Main_Menu.messageFromServer;import static com.example.christian.pollvotingsoftware.Main_Menu.messageToServer;import static java.net.InetAddress.getByName;/** * Created by Christian on 27-04-2017. */public class Poll_Overview extends AppCompatActivity {    public Button createpoll;    public Button getresults;    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.cont_polls_overview);        createpoll = (Button) findViewById(R.id.createpoll);        getresults = (Button) findViewById(R.id.getresults);        init();    }    public void init() {////        loadFromServer();//        try {//            InetAddress IP = getByName("10.0.2.2");////            setIP(IP);//            Socket clientSocket = new Socket(IP, 4445);////            setClientSocket(clientSocket);//            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());//        }catch (IOException e){//            e.printStackTrace();//        }        String[] loadedPolls = messageFromServer.split(";");        for(int i = 0; i < loadedPolls.length;i++){            Log.d("messagefromserver", loadedPolls[i]);        }//        String[] tempStringArray = loadedPolls[2].split(",");//        Log.d("specific string", String.valueOf(tempStringArray.length));//                tempStringArray.length);//        tempStringArray[4]);        View.OnClickListener mFan = new View.OnClickListener()        {            public void onClick(View v)            {                Log.d("Buttontest","CLICKED");                Log.d("Buttontest",v.getContext().getPackageName());            }        };        int rowcount = 0;        TableLayout ll = (TableLayout) findViewById(R.id.displayLinear);        for (int i = 0; i < loadedPolls.length;i++){            TableRow desc = new TableRow(this);            TableRow.LayoutParams pl = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);            desc.setLayoutParams(pl);            TextView description = new TextView(this);            description.setText(loadedPolls[i].split(",")[3]);            desc.addView(description);            ll.addView(desc, rowcount);            rowcount++;            String tempString;            TableRow row = new TableRow(this);            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);            row.setLayoutParams(lp);            Button button = new Button(this);            Button button2 = new Button(this);            Log.d("arraytest",String.valueOf(loadedPolls.length));            tempString = loadedPolls[i].split(",")[4];            Log.d("arraytest",String.valueOf(loadedPolls.length));            button.setText(tempString);            Log.d("arraytest",String.valueOf(loadedPolls.length));            tempString = loadedPolls[i].split(",")[5];            Log.d("arraytest",String.valueOf(loadedPolls.length));            button2.setText(tempString);            button.setOnClickListener(mFan);            button2.setOnClickListener(mFan);//            button.setId();            row.addView(button);            row.addView(button2);            ll.addView(row, rowcount);            rowcount++;        }//        for (int i = 0; i < loadedPolls.length*2; i++) {//            if (i % 2 == 0) {//                TableRow desc = new TableRow(this);//                TableRow.LayoutParams pl = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);//                desc.setLayoutParams(pl);//                TextView description = new TextView(this);//                description.setText(loadedPolls[i].split(",")[3]);////                description.setText("TESTING");//                desc.addView(description);//                ll.addView(desc, i);//            } else {//                TableRow row = new TableRow(this);//                TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);//                row.setLayoutParams(lp);//                Button button = new Button(this);//                Button button2 = new Button(this);//                button.setText(loadedPolls[i].split(",")[3]);//                row.addView(button);//                row.addView(button2);//                ll.addView(row, i);//            }//        }    }//    public String[] loadFromServer() {//        String modifiedSentence;//        try {//            Main_Menu.outToServer.writeBytes("loadPolls" + '\n');//            //waits and read input from, maybe not necessary in all cases//            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));//            //modified sentence == results from server//            modifiedSentence = inFromServer.readLine();//            System.out.println(modifiedSentence);//        } catch (IOException e) {//            e.printStackTrace();//        }////        if (modifiedSentence != null) {////            System.out.println(modifiedSentence);////        }////        System.out.println("reaches here");//return null;//    }    public void createPoll(View view) {        Intent g = new Intent(Poll_Overview.this, Create_Poll.class);        startActivity(g);    }    public void getResults(View view) {        Intent g = new Intent(Poll_Overview.this, Get_Results.class);        startActivity(g);    }    public void voteClick(View view){        //Start socket again//        Thread thread = new Thread(new Runnable() {////            @Override//            public void run() {//                try {//                    try {//                        InetAddress IP = InetAddress.getByName("10.0.2.2");//                        Socket clientSocket = new Socket(IP, 4445);//                        Log.d("Servertesting", "creates socket");//                        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());//                        Log.d("Servertesting", "establishes outputstream");//                        outToServer.writeBytes(messageToServer + "\n");//                        Log.d("SENT", "Message is sent to server");////////                        //waits and read input from, maybe not necessary in all cases//                        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));//                        Log.d("From server", "received shit from server");//                        //modified sentence == results from server//                        messageFromServer = inFromServer.readLine();//                        Log.d("From server", messageFromServer);//                        clientSocket.close();//                        outToServer.close();//                        inFromServer.close();//                    } catch (IOException e) {//                        e.printStackTrace();//                    }//                    //Your code goes here//                } catch (Exception e) {//                    e.printStackTrace();//                }//            }//        });//        thread.start();//        try {//            thread.join();//            Log.d("finishthread", "thread ends");//        } catch (InterruptedException e) {//            e.printStackTrace();//        }        //Send to server: votepoll, with; pollnumber,newresult,newresult    }}