package com.example.joelbaumann.morsetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TranslateOptions extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate_options);
        setTitle("Translate options");
    }

    //onClick wechselt zu ToText
    public void loadToText(View view) {startActivity(new Intent(this,ToText.class));}
    //onClick wechselt zu ToMorse
    public void loadToMorse(View view) {startActivity(new Intent(this,ToMorse.class));}
}
