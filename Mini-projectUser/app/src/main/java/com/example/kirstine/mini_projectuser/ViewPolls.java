package com.example.kirstine.mini_projectuser;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Kirstine on 27-04-2017.
 */


//Array of options, which will run through an ArrayAdapter, that will show in the ListView
//Array of options --> ArrayAdapter --> ListView

//List view: {views: da_items.xml}


public class ViewPolls extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_ViewPolls);

        populateListView();
        registerClickCallback();

    }

    //Called when the user touches button "back"
    public void back3 (View view) {
        //Goes back to the Menu
        Intent i = new Intent(ViewPolls.this, MainMenu.class);
        startActivity(i);
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
                Toast.makeText(ViewPolls.this, message, Toast.LENGTH_LONG).show();
            }

        });

    }
}
