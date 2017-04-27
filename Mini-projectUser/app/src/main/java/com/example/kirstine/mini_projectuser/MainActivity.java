package com.example.kirstine.mini_projectuser;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_menu);


    }

    //Called when the user touches button "View polls"
    public void message1(View view) {
        //Does something in response to the button click
        Intent i = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(i);
    }

    //Called when the user touches button "Make poll"
    public void message2(View view) {
        //Does something in response to the button click
        Intent i1 = new Intent(MainActivity.this, MainActivity3.class);
        startActivity(i1);
    }

    //Called when the user touches button "View Results"
    public void message3 (View view) {
        //Does something in response to button click
        Intent i2 = new Intent(MainActivity.this, MainActivity4.class);
        startActivity(i2);
    }
}




