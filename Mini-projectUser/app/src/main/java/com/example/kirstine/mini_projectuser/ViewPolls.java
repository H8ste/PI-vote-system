package com.example.kirstine.mini_projectuser;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by Kirstine on 27-04-2017.
 */


//Array of options, which will run through an ArrayAdapter, that will show in the ListView
//Array of options --> ArrayAdapter --> ListView

//List view: {views: da_items.xml}


public class ViewPolls extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_viewpolls);

        init();

//        populateListView();
//        registerClickCallback();

    }

    //Called when the user touches button "back"
    public void back3(View view) {
        //Goes back to the Menu
        Intent i = new Intent(ViewPolls.this, MainMenu.class);
        startActivity(i);
    }

//    private void populateListView() {
//        //Create list of items
//        String[] myItems = {"Blue", "Green", "Purple", "Red"};
//
//
//        //Build Adapter
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                this,                   // Context for the activity.
//                R.layout.da_items,      //Layout to use (create)
//                myItems);               //Items to be displayed
//
//
//        // Configure the list view
////        ListView list = (ListView) findViewById(R.id.ListViewMain);
////        list.setAdapter(adapter);
//    }

//    private void registerClickCallback() {
//        ListView list = (ListView) findViewById(R.id.ListViewMain);
//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
//                TextView textView = (TextView) viewClicked;
//                String message = "You Clicked # " + position + ", which is string:" + textView.getText().toString();
//                Toast.makeText(ViewPolls.this, message, Toast.LENGTH_LONG).show();
//            }
//
//        });
//
//    }

    public void init() {
        TableLayout ll = (TableLayout) findViewById(R.id.displayLinear);
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                TableRow desc = new TableRow(this);
                TableRow.LayoutParams pl = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
                desc.setLayoutParams(pl);
                TextView description = new TextView(this);
                description.setText("TESTING");
                desc.addView(description);
                ll.addView(desc, i);
            } else {
                TableRow row = new TableRow(this);
                TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
                row.setLayoutParams(lp);
                Button button = new Button(this);
                Button button2 = new Button(this);
                row.addView(button);
                row.addView(button2);
                ll.addView(row, i);
            }
        }
    }
}
