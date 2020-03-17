package com.example.joelbaumann.morsetest;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.support.v7.app.AppCompatActivity;

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
    //überprüft die Zeit des impulses und ordnet sie ein
    public void checkTime(float duration){
        long pauseTime = 50;
        long shortTime = 200;
        long longTime = 350;
        long wordTime = 500;
        long stopTime = 750;
        if (duration <= pauseTime+75 && duration >= pauseTime-75){
            //wenn "space" erkennt wurde
            activity.output.setText(activity.output.getText().toString()+" ");
        }else if ((duration <= shortTime+75 && duration > pauseTime+75) && duration >= shortTime-75){
            //wenn "short" erkennt
            activity.output.setText(activity.output.getText().toString()+"•");
        }else if ((duration <= longTime+75 && duration > shortTime+75) && duration >= longTime-75){
            //wenn "long" erkennt
            activity.output.setText(activity.output.getText().toString()+"─");
        }else if ((duration <= wordTime+75 && duration > longTime+75) && duration >= wordTime-75){
            //wenn "Wordende" erkennt
            activity.output.setText(activity.output.getText().toString()+"|");
        }else if ((duration <= stopTime+75 && duration > wordTime+75) && duration >= stopTime-75){
            //wenn "stop" erkennt
            sensorManager.unregisterListener(lightSensorListener);
            System.out.println("stoped");
        }
    }
    //testing only
    public void detectShort(float time){
       // activity.out.setText("short   :"+time);
    }
    //testing only
    public void detectLong(float time){
        //activity.i.setText("long    :"+time);

    }
}
