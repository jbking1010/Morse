package com.example.joelbaumann.morsetest;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        Switch sound = findViewById(R.id.swSound);
        Switch vibration = findViewById(R.id.swVibration);
        Switch dark = findViewById(R.id.swDark);


    }

    public void saveSettings(View view) {
        SharedPreferences sp = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putBoolean(SWITCH_SOUND,sound.isChecked());
        editor.putBoolean(SWITCH_VIBRATION,vibration.isChecked());
        editor.putBoolean(SWITCH_DARK,dark.isChecked());
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
        return sp.getBoolean(SWITCH_DARK,false);
    }
}
