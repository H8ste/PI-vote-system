package com.example.christian.pollvotingsoftware;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by Christian on 27-04-2017.
 */

public class Poll_Overview extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cont_polls_overview);

        init();
    }

    public void init() {
        pollsFromServer();

        TableLayout ll = (TableLayout) findViewById(R.id.displayLinear);
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                TableRow desc = new TableRow(this);
                TableRow.LayoutParams pl = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
                desc.setLayoutParams(pl);
                TextView description = new TextView(this);
                description.setText("NEW TESTING");
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
