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
    public void message1(View view1) {
        //Does something in response to the button click
        Intent i = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(i);
    }

    //Called when the user touches button "Make poll"
    public void message2(View view2) {
        //Does something in response to the button click
        Intent i1 = new Intent(MainActivity.this, MainActivity3.class);
        startActivity(i1);
    }
}




