package com.example.joelbaumann.morsetest;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.joelbaumann.morsetest.Settings.SHARED_PREFS;
import static com.example.joelbaumann.morsetest.Settings.SWITCH_DARK;

public class Receive extends AppCompatActivity {

    private EditText input;
    private EditText output;
    private TextView tvError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);
        setTitle("Receive");
        input = (EditText)findViewById(R.id.etText);
        output= (EditText)findViewById(R.id.etMorse);
        tvError=(TextView)findViewById(R.id.tvError);
    }

    //onClick receive
    public void receive() {
        System.out.println("confiremed");
    }
    //confirmation popUp
    public void popUp(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Calibration");
        builder.setMessage("The Light level will be calibrated after you press the confirm Button");
        builder.setPositiveButton("Confirm",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        receive();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
