package com.example.joelbaumann.morsetest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Switch;

public class Settings extends AppCompatActivity {

    Switch sound;
    Switch vibration;
    Switch dark;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String SWITCH_SOUND = "switch_sound";
    public static final String SWITCH_VIBRATION = "switch_vibration";
    public static final String SWITCH_DARK = "switch_dark";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setTitle("Settings");

        sound = findViewById(R.id.swSound);
        vibration = findViewById(R.id.swVibration);
        dark = findViewById(R.id.swDark);

        try {
            System.out.println(getDarkSetting());
            sound.setChecked(getSoundSetting());
            vibration.setChecked(getVibrationSetting());
            dark.setChecked(getDarkSetting());
        }catch (Exception e){

        }


    }

    public void saveSettings(View view) {
        SharedPreferences sp = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putBoolean(SWITCH_SOUND,sound.isChecked()).commit();
        editor.putBoolean(SWITCH_VIBRATION,vibration.isChecked()).commit();
        editor.putBoolean(SWITCH_DARK,dark.isChecked()).commit();
        if(getDarkSetting()){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            finish();
            startActivity(getIntent());

        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            finish();
            startActivity(getIntent());
        }

    }
    public boolean getSoundSetting(){
        SharedPreferences sp = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        return sp.getBoolean(SWITCH_SOUND,true);
    }

    public boolean getVibrationSetting(){
        SharedPreferences sp = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        return sp.getBoolean(SWITCH_VIBRATION,true);
    }

    public boolean getDarkSetting(){
        SharedPreferences sp = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        return sp.getBoolean(SWITCH_DARK,true);
    }
    @Override
    public void onBackPressed(){
        System.exit(0);
    }

}
