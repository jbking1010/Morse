package com.example.joelbaumann.morsetest;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Switch;

public class Settings extends AppCompatActivity {

    Boolean sound;
    Boolean vibration;
    Boolean dark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setTitle("Settings");

        Switch swSound = findViewById(R.id.swSound);
        Switch swVibration = findViewById(R.id.swVibration);
        Switch swDark = findViewById(R.id.swDark);

        sound = swSound.isActivated();
        vibration = swVibration.isActivated();
        dark = swDark.isActivated();
    }
}
