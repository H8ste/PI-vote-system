package com.example.christian.pollvotingsoftware;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Christian on 27-04-2017.
 */

public class Get_Results extends AppCompatActivity {
    String temp = "0,0,Yes or no?,Yes,No";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_get_results);
        {
            String[] parts = temp.split(",");
            for (int i=0; i<parts.length; i++){
                Log.d("hansi", parts[i]);

        }

        }

    }
}
