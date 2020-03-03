package com.example.joelbaumann.morsetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

import java.util.Set;

public class Home extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        setTitle("Home");
        ImageView img = (ImageView) findViewById(R.id.ivSettings);
        img.setImageResource(R.mipmap.gear_dark);
    }

    /*/public void loadHome(MainActivity main){
        this.main = main;
        main.setContentView(R.layout.activity_home);
        main.setTitle("Home");
        ImageView iv = findViewById(R.id.ivSettings);
    }*/
    public void loadSettings(View view) {
        startActivity(new Intent(this, Settings.class));
    }


    public void loadCommunicate(View view) {startActivity(new Intent(this,Communicate.class)); }

    public void loadTranslate(View view) {startActivity(new Intent(this,TranslateOptions.class)); }

    public void setDark(){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

    }

    public void setLight(){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

    }
}
