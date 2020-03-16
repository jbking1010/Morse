package com.example.joelbaumann.morsetest;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
/*/////////////////////////////////////////////////////
/////////   Testing only //////////////////////////////
////////////////////////////////////////////////////*/
    boolean einstellungVibration = false;
    boolean einstellungSound = true;

    TextView input1;
    TextView input2;
    Button scanLight;
    Button scanSound;
    Button buttonFlash;
    //float valueLight;
    final Handler handler = new Handler();

    //Boolean timing = false;

    float base;
    Flash flash;
    LightSensor light;
    Morse m = new Morse();
    EditText textField;
    EditText morseField;

    Home home = new Home();






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Intent launchNew =new Intent(MainActivity.this,Home.class);
        startActivity(launchNew);*/


        /*flash = new Flash(this);
        light = new LightSensor(this);
        input1= findViewById(R.id.input1);
        input2= findViewById(R.id.input2);
        scanLight = findViewById(R.id.scanLight);
        scanSound = findViewById(R.id.scanSound);
        buttonFlash = findViewById(R.id.buttonFlash);
       // SensorManager mySensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
       // Sensor lightSensor = mySensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        //mySensorManager.registerListener(lightSensorListener,lightSensor,SensorManager.SENSOR_DELAY_NORMAL);


        scanLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                light.setBase();
            }
        });
        scanSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        buttonFlash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flash.flashShort();
                flash.flashShort();
                flash.flashShort();
                flash.flashLong();
                flash.flashLong();
                flash.flashLong();

            }
        });
        textField = findViewById(R.id.txtText);
        morseField = findViewById(R.id.txt_morse);*/

    }

    public void convert(View view) {


        String morse = morseField.getText().toString();
        String text = textField.getText().toString();

        /*if (morse.length() > 0 && text.length()==0){
            if(m.checkMorse(morse)){
                //textField.setText(m.convertToText(morse));
            }

        }else if (morse.length() == 0 && text.length() > 0){
            if (m.checkText(text)){
                morseField.setText("valid");
                m.convertToMorse(text);
            }
        }*/
    }


    @Override
    public void onBackPressed(){

    }
    public void load(){
        startActivity(new Intent(this,Home.class));

    }


}
