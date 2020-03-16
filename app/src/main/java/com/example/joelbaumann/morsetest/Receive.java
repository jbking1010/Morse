package com.example.joelbaumann.morsetest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static com.example.joelbaumann.morsetest.Settings.SHARED_PREFS;
import static com.example.joelbaumann.morsetest.Settings.SWITCH_DARK;

public class Receive extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);
        setTitle("Receive");
    }

    public static class TranslateOptions extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_translate_options);
            if(getDarkSetting()){

            }
            setTitle("Translate options");
        }

        public void loadToText(View view) {startActivity(new Intent(this,ToText.class));}

        public void loadToMorse(View view) {startActivity(new Intent(this,ToMorse.class));}

        public boolean getDarkSetting(){
            SharedPreferences sp = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
            return sp.getBoolean(SWITCH_DARK,true);
        }
    }
}
