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

    float valueLight;
    float base;
    Boolean timing = false;
    long tStart;
    long tStop;
    MainActivity activity;

    public LightSensor(Activity activity){
        SensorManager sensorManager = (SensorManager) activity.getSystemService(SENSOR_SERVICE);
        Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorManager.registerListener(lightSensorListener,lightSensor,SensorManager.SENSOR_DELAY_NORMAL);
        this.activity = (MainActivity)activity;
    }

    private final SensorEventListener lightSensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT){
                valueLight = sensorEvent.values[0];
                checkLight();
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };

    public void setBase(){
        base = valueLight;
    }


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
    public void checkTime(float duration){
        long shortTime = 150;
        long longTime = 300;
        if (duration <= shortTime+75 && duration >= shortTime-75){
            detectShort(duration);
        }else if ((duration <= longTime+75 && duration > shortTime+75) && duration >= longTime-75){
            detectLong(duration);
        }
    }
    public void detectShort(float time){
        activity.input2.setText("short   :"+time);
    }
    public void detectLong(float time){
        activity.input2.setText("long    :"+time);

    }
}
