package com.example.joelbaumann.morsetest;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.MediaPlayer;
import android.os.SystemClock;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.MediaStore;

import static android.content.Context.MODE_PRIVATE;


public class Flash{

    CameraManager cameraManager;
     final MediaPlayer soundShort;
     final MediaPlayer soundLong;
     final MediaPlayer soundpause;
     Activity activity;
     Vibrator vib;



    public Flash(Activity activity){
        this.cameraManager = (CameraManager)activity.getSystemService(Context.CAMERA_SERVICE);
        vib = (Vibrator)activity.getSystemService(Context.VIBRATOR_SERVICE);
        soundShort = MediaPlayer.create(activity, R.raw.soundshort);
        soundLong = MediaPlayer.create(activity, R.raw.soundlong);
        soundpause = MediaPlayer.create(activity, R.raw.soundpause);
        this.activity = activity;

    }
    //Clitzt einmal kurz
    public void flashShort(){
        flash(300,soundShort);
    }
    //blitzt einmal lang
    public void flashLong(){
        flash(500,soundLong);
    }
    //blitzt lange für einen Leerschkag
    public void flashPause(){flash(100,soundpause);}
    //blitzt länge für ein neues word
    public void flashWord(){flash(700,soundpause);}
    //blitzt länge für stop
    public void flashStop(){flash(1000,soundpause);}

    //Blitz methode
    private void flash(int duration, MediaPlayer sound){
        try {
            //wenn auf eine Kamera zugegriffen werden kann
            String cameraId = cameraManager.getCameraIdList()[0];
            //Schaltet den Blitz an
            cameraManager.setTorchMode(cameraId, true);
            //wenn der Sound aktiviert ist
            if (getSoundSetting())
                sound.start();
            //wenn vibration aktiviert ist
            if (getVibrationSetting())
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
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String SWITCH_SOUND = "switch_sound";
    public static final String SWITCH_VIBRATION = "switch_vibration";

    public boolean getSoundSetting(){
        SharedPreferences sp = activity.getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        return sp.getBoolean(SWITCH_SOUND,true);
    }

    public boolean getVibrationSetting(){
        SharedPreferences sp = activity.getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        return sp.getBoolean(SWITCH_VIBRATION,true);
    }

}
