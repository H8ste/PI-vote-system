package com.example.kirstine.mini_projectuser;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Kirstine on 27-04-2017.
 */

public class MainActivity4 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_view_results);
    }
    //Called when the user touches button "View polls"
    public void message4 (View view) {
        //Does something in response to the button click
        Intent i = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(i);
    }
}
