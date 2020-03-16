package com.example.joelbaumann.morsetest;

import android.app.Activity;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.MediaPlayer;
import android.os.SystemClock;
import android.os.VibrationEffect;
import android.os.Vibrator;


public class Flash{

     CameraManager cameraManager;
     final MediaPlayer soundShort;
     final MediaPlayer soundLong;
     MainActivity main;
     Vibrator vib;



    public Flash(MainActivity main){
        this.cameraManager = (CameraManager)main.getSystemService(Context.CAMERA_SERVICE);
        vib = (Vibrator)main.getSystemService(Context.VIBRATOR_SERVICE);
        soundShort = MediaPlayer.create(main, R.raw.soundshort);
        soundLong = MediaPlayer.create(main, R.raw.soundlong);
        this.main = main;

    }
    //Clitzt einmal kurz
    public void flashShort(){
        flash(175,soundShort);
    }
    //blitzt einmal lang
    public void flashLong(){
        flash(350,soundLong);
    }

    //Blitz methode
    private void flash(int duration, MediaPlayer sound){
        try {
            //wenn auf eine Kamera zugegriffen werden kann
            String cameraId = cameraManager.getCameraIdList()[0];
            //SChaltet den Blitz an
            cameraManager.setTorchMode(cameraId, true);
            //wenn der Sound aktiviert ist
            if (main.einstellungSound)
                sound.start();
            //wenn vibration aktiviert ist
            if (main.einstellungVibration)
                vib.vibrate(duration);
            //bestimmt die Milisekunden der dauer des Blitzes
            SystemClock.sleep(duration);
            //Blitz Ausschalten
            cameraManager.setTorchMode(cameraId, false);
            //warten nach Blitz
            SystemClock.sleep(500);

        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

}
