package edu.css.smueggenberg.grocerylist;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;


public class EntryActivity extends ActionBarActivity {

    TextView lblNumber;
    EditText txtItem;
    EditText txtPhone;
    SeekBar sbAmount;

    Button btnAdd;
    Button btnPreview;
    Button btnText;

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
                
            }
        });

        btnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void setNumberLabel(){
        lblNumber.setText(Integer.toString(sbAmount.getProgress()));
    }
}