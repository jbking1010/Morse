package com.example.joelbaumann.morsetest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Home extends AppCompatActivity {

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String SWITCH_SOUND = "switch_sound";
    public static final String SWITCH_VIBRATION = "switch_vibration";
    public static final String SWITCH_DARK = "switch_dark";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setTheme();
        setTitle("Home");
        setImages();
    }
    public void setTheme(){

        if(getDarkSetting()){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            setContentView(R.layout.activity_home);

        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            setContentView(R.layout.activity_home);

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

    public void loadTranslate(View view) {startActivity(new Intent(this, TranslateOptions.class)); }



    public void setImages(){
        ImageButton ibTranslate = (ImageButton) findViewById(R.id.ibTranslate);
        ImageView ivSettings = (ImageView) findViewById(R.id.ivSettings);
        ImageButton ibCommunicate = (ImageButton) findViewById(R.id.ibCommunicate);


        if(getDarkSetting()){
            ibCommunicate.setImageResource(R.mipmap.communicate_dark);
            ibTranslate.setImageResource(R.mipmap.translate_dark);
            ivSettings.setImageResource(R.mipmap.gear_dark);

        }else{
            ivSettings.setImageResource(R.mipmap.gear);
            ibTranslate.setImageResource(R.mipmap.translate);
            ibCommunicate.setImageResource(R.mipmap.communicate);}
    }

    public boolean getDarkSetting(){
        SharedPreferences sp = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        return sp.getBoolean(SWITCH_DARK,true);
}
}
