package edu.css.smueggenberg.grocerylist;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class EntryActivity extends ActionBarActivity {

    // Creates all the variables that will be used in the app
    TextView lblNumber;
    EditText txtItem;
    EditText txtPhone;
    SeekBar sbAmount;

    Button btnAdd;
    Button btnPreview;
    Button btnText;

    ArrayList<String> items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        // Links the widgets in the app to the code
        txtItem = (EditText) findViewById(R.id.txtItem);
        txtPhone = (EditText) findViewById(R.id.txtPhone);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnPreview = (Button) findViewById(R.id.btnPreview);
        btnText = (Button) findViewById(R.id.btnText);

        // Contains an array of the grocery items
        items = new ArrayList<>();

        /**
         * Sets the on click listener for the "Add" button
         * This adds the current text above to the grocery list
         */
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // If the text is not empty, add the item to the list
                if (!txtItem.getText().toString().equals("")) {
                    items.add(txtItem.getText().toString());
                }
                txtItem.setText("");
            }
        });

        /**
         * Sets the on click listener for the "Preview List" button
         * This calls a new activity within the app that displays all the items added so far
         */
        btnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EntryActivity.this, ViewActivity.class);

                i.putStringArrayListExtra("groceryItems", items);

                startActivity(i);
            }
        });

        /**
         * Sets the on click listener for the "Text me my list" button
         * This calls the messenger app on the phone using the user's number and sets the message to the items in the grocery list
         */
        btnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // If the number in the "phone" text field has enough digits to be a real number
                // Else display an error message
                if (txtPhone.getText().toString().length() == 10) {
                    Intent i = new Intent(Intent.ACTION_VIEW);

                    // Add the phone number entered in the phone number text field
                    i.setData(Uri.parse("sms:" + txtPhone.getText().toString()));

                    // Add the message to the extras
                    i.putExtra("sms_body", createGroceryList());

                    if(i.resolveActivity(getPackageManager()) != null){
                        startActivity(i);
                    }
                }else{
                    Toast.makeText(EntryActivity.this, "Please enter a valid 10 digit number in the proper format", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    /**
     * Creates a grocery list from a string array of grocery items
     * @return The string containing the formatted grocery list
     */
    public String createGroceryList(){
        String list = "";

        for (int i = 0; i < items.size(); i++){
            if (i + 1 == items.size()){
                list += items.get(i);
            }else {
                list += items.get(i)
                        + "\n";
            }
        }

        return list;
    }
}
