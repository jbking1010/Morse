package com.example.joelbaumann.morsetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;

import java.util.Set;

public class Home extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        setTitle("Home");
        setImages();
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
    public void setImages(){
        ImageView ivSettings = (ImageView) findViewById(R.id.ivSettings);
        //Gear for Dark Theme
        ivSettings.setImageResource(R.mipmap.gear_dark);
        //Gear for Light Theme
        ivSettings.setImageResource(R.mipmap.gear);

        ImageButton ibTranslate = (ImageButton) findViewById(R.id.ibTranslate);
        //Translate for Dark Theme
        ibTranslate.setImageResource(R.mipmap.translate_dark);
        //Translate for Light Theme
        ibTranslate.setImageResource(R.mipmap.translate);


        ImageButton ibCommunicate = (ImageButton) findViewById(R.id.ibCommunicate);
        //Communicate for Dark Theme
        ibCommunicate.setImageResource(R.mipmap.communicate_dark);
        //Communicate for Light Theme
        ibCommunicate.setImageResource(R.mipmap.communicate);
    }
}
