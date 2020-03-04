package com.example.joelbaumann.morsetest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static android.content.Context.MODE_PRIVATE;
import static com.example.joelbaumann.morsetest.Settings.SHARED_PREFS;
import static com.example.joelbaumann.morsetest.Settings.SWITCH_DARK;
import static com.example.joelbaumann.morsetest.Settings.SWITCH_SOUND;
import static com.example.joelbaumann.morsetest.Settings.SWITCH_VIBRATION;

public class getSettings extends AppCompatActivity {



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
