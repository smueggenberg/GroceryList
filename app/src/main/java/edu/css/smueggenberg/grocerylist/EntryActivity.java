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

import java.util.ArrayList;


public class EntryActivity extends ActionBarActivity {

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

        lblNumber = (TextView) findViewById(R.id.lblNumber);
        txtItem = (EditText) findViewById(R.id.txtItem);
        txtPhone = (EditText) findViewById(R.id.txtPhone);
        sbAmount = (SeekBar) findViewById(R.id.sbAmount);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnPreview = (Button) findViewById(R.id.btnPreview);
        btnText = (Button) findViewById(R.id.btnText);

        items = new ArrayList<>();

        sbAmount.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    setNumberLabel();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {}

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {}
            }

        );

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.add(txtItem.getText().toString());
                txtItem.setText("");
            }
        });

        btnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EntryActivity.this, ViewActivity.class);

                i.putStringArrayListExtra("groceryItems", items);

                startActivity(i);
            }
        });

        btnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // If the number in the "phone" text field has enough digits to be a real number
                if (txtPhone.getText().toString().length() == 10) {
                    Intent i = new Intent(Intent.ACTION_VIEW);

                    // Enter the phone number entered in the phone number text field
                    i.setData(Uri.parse("sms:" + txtPhone.getText().toString()));

                    // Add the message to the extras

                    // TODO: put the message into the extras using "createGroceryList"
                    // i.putExtra

                    if(i.resolveActivity(getPackageManager()) != null){
                        startActivity(i);
                    }
                }
            }
        });
    }

    public void setNumberLabel(){
        lblNumber.setText(Integer.toString(sbAmount.getProgress()));
    }

    // TODO: finish the "createGroceryList" method. (Converts ArrayList items into an appropriate string message
    // public String createGroceryList()
}
