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

    getSettings settings = new getSettings();



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //setTheme();
        setContentView(R.layout.activity_home);
        setTitle("Home");
        //setImages();
    }
    public void setTheme(){

        try{
            //settings.saveSettings(null);

            if(settings.getDarkSetting()){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }}catch (Exception e){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

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



    public void setImages(){
        ImageButton ibTranslate = (ImageButton) findViewById(R.id.ibTranslate);
        ImageView ivSettings = (ImageView) findViewById(R.id.ivSettings);
        ImageButton ibCommunicate = (ImageButton) findViewById(R.id.ibCommunicate);


        if(settings.getDarkSetting()){
            ibTranslate.setImageResource(R.mipmap.translate_dark);
            ivSettings.setImageResource(R.mipmap.gear_dark);
            ibCommunicate.setImageResource(R.mipmap.communicate_dark);

        }else{
        ivSettings.setImageResource(R.mipmap.gear);
        ibTranslate.setImageResource(R.mipmap.translate);}
        ibCommunicate.setImageResource(R.mipmap.communicate);
    }
}
