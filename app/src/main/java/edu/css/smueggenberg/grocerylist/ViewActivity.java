package edu.css.smueggenberg.grocerylist;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class ViewActivity extends ActionBarActivity {

    ListView list;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        // Link the widget in the app to the code
        list = (ListView) findViewById(R.id.lstGroceries);

        extras = getIntent().getExtras();

        // Get the array of grocery items from extras
        ArrayList items = extras.getStringArrayList("groceryItems");

        // Set the items array as the adapter for the ListView
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, items);
        list.setAdapter(adapter);
    }
}
