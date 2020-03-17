package com.example.joelbaumann.morsetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class Send extends AppCompatActivity {

    private EditText input;
    private EditText output;
    private TextView tvError;
    Morse morse = new Morse();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        setTitle("Send");
        input = (EditText)findViewById(R.id.etText);
        input.requestFocus();
        output = (EditText)findViewById(R.id.etOutput);
        tvError = (TextView)findViewById(R.id.tvError);
        tvError.setVisibility(View.INVISIBLE);
    }

    public void send(View view) {
        if (input.getText().toString()!=""){
            String in = input.getText().toString();
            if (morse.checkText(in)){
                tvError.setVisibility(View.INVISIBLE);
                String morseCode = morse.convertToMorse(in);
                convert(morseCode);
            }else{
                tvError.setVisibility(View.VISIBLE);
                input.setText("");
            }
        }
    }

    public void convert(String code){
        String space = "   ";
        String[] splitArray = code.split(space);
        sendMorse(splitArray);
    }
    public void sendMorse(String[] array){
        System.out.println(Arrays.toString(array));
        for(String s :array){
            for (int i = 0;i < s.length();i++){
                System.out.println(s.charAt(i));
            }
        }
    }
}
