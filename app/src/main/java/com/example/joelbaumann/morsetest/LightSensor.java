package com.example.joelbaumann.morsetest;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static android.content.Context.SENSOR_SERVICE;

public class LightSensor extends AppCompatActivity {

    SensorManager sensorManager;
    Sensor sensor;


    float valueLight;
    float base;
    Boolean timing = false;
    long tStart;
    long tStop;
    Receive activity;
    Morse morse = new Morse();

    public LightSensor(Activity activity){
        sensorManager = (SensorManager) activity.getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorManager.registerListener(lightSensorListener,sensor,SensorManager.SENSOR_DELAY_NORMAL);
        this.activity = (Receive) activity;
    }

    private final SensorEventListener lightSensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            //wenn sich das Lichtverhältniss verändert
            if (sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT){
                valueLight = sensorEvent.values[0];
                checkLight();
            }
        }
        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {}
    };

    //setzt den messwert
    public void setBase(){
        base = valueLight;
    }


    //überprüft das licht level und misst die Zeit des impulses
    public void checkLight(){
        if (base > 0 && valueLight > base+25 && !timing){
            timing = true;
            tStart = System.currentTimeMillis();
        }else if (timing && valueLight < base + 25){
            tStop = System.currentTimeMillis();
            checkTime(tStop-tStart);
            timing=false;
        }
    }
    long pauseTime = 0;
    long shortTime = 0;
    long longTime = 0;
    long wordTime = 0;
    long stopTime = 0;

    //überprüft die Zeit des impulses und ordnet sie ein
    public void checkTime(float duration){
        System.out.println(duration);
        if (pauseTime == 0){
            pauseTime = (long)duration;
        }else if (shortTime == 0){
            shortTime =(long)duration;
        }else if (longTime == 0){
            longTime =(long)duration;
        }else if (wordTime == 0){
            wordTime =(long)duration;
        }else if (stopTime == 0){
            stopTime =(long)duration;
        }
        else{
        long buffer = 80;
        /*long pauseTime = baseTime/10;
        long shortTime = (baseTime/10)*3;
        long longTime = baseTime/2;
        long wordTime = (baseTime/10)*7;
        long stopTime = baseTime;*/
        if (duration <= pauseTime+buffer && duration >= pauseTime-buffer){
            //wenn "space" erkennt wurde
            activity.output.setText(activity.output.getText().toString()+" ");
        }else if ((duration <= shortTime+buffer && duration > pauseTime+buffer) && duration >= shortTime-buffer){
            //wenn "short" erkennt
            activity.output.setText(activity.output.getText().toString()+"•");
        }else if ((duration <= longTime+buffer && duration > shortTime+buffer) && duration >= longTime-buffer){
            //wenn "long" erkennt
            activity.output.setText(activity.output.getText().toString()+"─");
        }else if ((duration <= wordTime+buffer && duration > longTime+buffer) && duration >= wordTime-buffer){
            //wenn "Wordende" erkennt
            activity.output.setText(activity.output.getText().toString()+"|");
        }else if ((duration <= stopTime+buffer && duration > wordTime+buffer) && duration >= stopTime-buffer){
            //wenn "stop" erkennt
            sensorManager.unregisterListener(lightSensorListener);
            //System.out.println("stoped");
            stop();
        }
    }}
    public void stop(){
        String[] array = activity.output.getText().toString().split(" ");
        ArrayList<String> arrayList =new ArrayList<>(Arrays.asList(array));


        try {
            activity.input.setText(morse.convertToText(arrayList));

        }catch (Exception e) {
            System.out.println("Invalid values");
            activity.input.setText("Invalid Input");

        }
        }

}
