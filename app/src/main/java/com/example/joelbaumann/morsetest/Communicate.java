package com.example.joelbaumann.morsetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Communicate extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communicate);
        setTitle("Communicate");
    }

    public void loadSend(View view) {startActivity(new Intent(this,Send.class));}

    public void loadReceive(View view) {startActivity(new Intent(this,Receive.class));}
}
