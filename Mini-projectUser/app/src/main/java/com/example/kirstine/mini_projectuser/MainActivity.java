package com.example.kirstine.mini_projectuser;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

//Imports the needed widgets
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


//Array of options, which will run through an ArrayAdapter, that will show in the ListView
//Array of options --> ArrayAdapter --> ListView

//List view: {views: da_items.xml}


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                populateListView();
                registerClickCallback();

        }

        private void populateListView() {
            //Create list of items
            String[] myItems = {"Blue", "Green", "Purple", "Red"};


            //Build Adapter
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    this,                   // Context for the activity.
                    R.layout.da_items,      //Layout to use (create)
                    myItems);               //Items to be displayed


            // Configure the list view
            ListView list = (ListView) findViewById(R.id.ListViewMain);
            list.setAdapter(adapter);
    }

        private void registerClickCallback() {
        ListView list = (ListView) findViewById(R.id.ListViewMain);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textView = (TextView) viewClicked;
                String message = "You Clicked # " + position + ", which is string:" + textView.getText().toString();
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }

        });

    }
    }



