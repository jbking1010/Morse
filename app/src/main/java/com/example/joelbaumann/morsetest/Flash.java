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

    public void flashShort(){
        flash(175,soundShort);
    }

    public void flashLong(){
        flash(350,soundLong);
    }

    private void flash(int duration, MediaPlayer sound){
        try {
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, true);
            if (main.einstellungSound)
            sound.start();
            if (main.einstellungVibration)
            vib.vibrate(duration);
            SystemClock.sleep(duration);
            cameraManager.setTorchMode(cameraId, false);
            SystemClock.sleep(500);

        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

}
