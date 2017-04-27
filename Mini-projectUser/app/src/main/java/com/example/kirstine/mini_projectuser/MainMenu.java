package com.example.kirstine.mini_projectuser;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_menu);


    }

    //Called when the user touches button "View polls"
    public void viewPolls(View view) {
        //Goes to class called ViewPolls
        Intent i = new Intent(MainMenu.this, ViewPolls.class);
        startActivity(i);
    }

    //Called when the user touches button "Make poll"
    public void makePoll(View view) {
        //Goes to class called MakePoll
        Intent i1 = new Intent(MainMenu.this, MakePoll.class);
        startActivity(i1);
    }

    //Called when the user touches button "View Results"
    public void viewResults (View view) {
        //Goes to class called ViewResults
        Intent i2 = new Intent(MainMenu.this, ViewResults.class);
        startActivity(i2);
    }
}




