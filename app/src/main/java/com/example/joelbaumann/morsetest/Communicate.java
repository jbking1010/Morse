package com.example.joelbaumann.morsetest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static com.example.joelbaumann.morsetest.Settings.SHARED_PREFS;
import static com.example.joelbaumann.morsetest.Settings.SWITCH_DARK;

public class Communicate extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communicate);
        setTitle("Communicate");

        Button btnSend = (Button)findViewById(R.id.btnSend);
        Button btnReceive = (Button)findViewById(R.id.btnReceive);

        if (getDarkSetting()){
            Drawable drawSend = getResources().getDrawable(R.mipmap.back_right_dark);
            btnSend.setCompoundDrawablesWithIntrinsicBounds(null, null, (drawSend), null);
            Drawable drawReceive = getResources().getDrawable(R.mipmap.back_left_dark);
            btnReceive.setCompoundDrawablesWithIntrinsicBounds(null, null, (drawReceive),null );
        }else{
            Drawable drawSend = getResources().getDrawable(R.mipmap.back_right);
            btnSend.setCompoundDrawablesWithIntrinsicBounds(null, null, (drawSend), null);
            Drawable drawReceive = getResources().getDrawable(R.mipmap.back_left);
            btnReceive.setCompoundDrawablesWithIntrinsicBounds(null, null, (drawReceive), null );
        }

    }

    public void loadSend(View view) {startActivity(new Intent(this,Send.class));}

    public void loadReceive(View view) {startActivity(new Intent(this,Receive.class));}

    public boolean getDarkSetting(){
        SharedPreferences sp = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        return sp.getBoolean(SWITCH_DARK,true);
    }
}
