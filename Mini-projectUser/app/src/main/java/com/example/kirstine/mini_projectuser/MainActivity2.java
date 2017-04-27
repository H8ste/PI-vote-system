package com.example.kirstine.mini_projectuser;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.x;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Kirstine on 27-04-2017.
 */


//Array of options, which will run through an ArrayAdapter, that will show in the ListView
//Array of options --> ArrayAdapter --> ListView

//List view: {views: da_items.xml}


public class MainActivity2 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

//        populateListView();
//        registerClickCallback();

        init();

    }

    //Called when the user touches button "View polls"
    public void message4(View view) {
        //Does something in response to the button click
        Intent i = new Intent(MainActivity2.this, MainActivity.class);
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

//
//        // Configure the list view
//        ListView list = (ListView) findViewById(R.id.ListViewMain);
//        list.setAdapter(adapter);
    }

//    private void registerClickCallback() {
//        ListView list = (ListView) findViewById(R.id.ListViewMain);
//        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
//                TextView textView = (TextView) viewClicked;
//                String message = "You Clicked # " + position + ", which is string:" + textView.getText().toString();
//                Toast.makeText(MainActivity2.this, message, Toast.LENGTH_LONG).show();
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
                ll.addView(desc,i);
            } else{
                TableRow row = new TableRow(this);
                TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
                row.setLayoutParams(lp);
                Button button = new Button(this);
                Button button2 = new Button(this);
                row.addView(button);
                row.addView(button2);
                ll.addView(row,i);
            }

//            TableRow row = new TableRow(this);
//            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
//            row.setLayoutParams(lp);
//            Button button = new Button(this);
//            Button button2 = new Button(this);
//            checkBox = new CheckBox(this);
//            tv = new TextView(this);
//            addBtn = new ImageButton(this);
//            addBtn.setImageResource(R.drawable.add);
//            minusBtn = new ImageButton(this);
//            minusBtn.setImageResource(R.drawable.minus);
//            qty = new TextView(this);
//            checkBox.setText("hello");
//            qty.setText("10");
//            row.addView(button);
//            row.addView(button2);
//            row.addView(qty);
//            row.addView(addBtn);
//            ll.addView(desc, i);
//            ll.addView(row, i);
        }
    }
}
