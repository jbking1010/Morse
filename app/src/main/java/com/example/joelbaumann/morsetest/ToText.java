package com.example.joelbaumann.morsetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class ToText extends AppCompatActivity implements View.OnClickListener {

    Morse morse = new Morse();
    ArrayList<String> input = new ArrayList<String>();
    String str = "";

    //input
    EditText etMorse;
    //output
    EditText etText;
    TextView tvError;

    Button btnDot;
    Button btnLine;
    Button btnSpace;
    Button btnPipe;
    Button btnDelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_text);
        setTitle("To Text");

        //definiert alle Elemente
        etMorse =(EditText)findViewById(R.id.etUserInput);
        etText =(EditText)findViewById(R.id.etOutput);
        tvError =(TextView)findViewById(R.id.tvError);
        tvError.setVisibility(View.INVISIBLE);

        btnDot = (Button)findViewById(R.id.btnDot);
        btnLine= (Button)findViewById(R.id.btnLine);
        btnSpace=(Button)findViewById(R.id.btnSpace);
        btnPipe =(Button)findViewById(R.id.btnPipe);
        btnDelete=(Button)findViewById(R.id.btnDelete);

    }

    //konventiert den Morsecode zu Text
    public void convertToText(View view) {

        if(!str.isEmpty()){
            input.add(str);}

        if(morse.checkMorse(input)){
            etText.setText(morse.convertToText(input));}
        //fügt fehlermeldung hinzu
        else{
            tvError.setVisibility(View.VISIBLE);clear();showMorse("");}
        input.clear();
        str="";

    }


    //Onclick für alle Buttons /unterscheided zwischen den einzelenen Buttons
    @Override
    public void onClick(View view) {
        Button b =(Button)findViewById(view.getId());
        tvError.setVisibility(View.INVISIBLE);
        switch(b.getText().toString()){
            case "•":
                //add charakter
                str += "•";
                break;
            case "─":
                //add charakter
                str += "─";
                break;
            case "|":
                //add charakter
                input.add(str);
                input.add("|");

                str = "";
                break;
            case "Space":
                if(!str.isEmpty())
                input.add(str);
                str = "";
                break;
            case"Delete":
                //remove the last charakter of the string
                if(!str.isEmpty())
                    removeLastChar();
                break;
            case"Clear":
                clear();
                break;
        }
        showMorse(str);
    }
    //cleared die Liste und den momentanen String
    private void clear(){
        input.clear();
        str ="";
    }
    //zeigt den Morse code im output an
    private void showMorse(String str){
        String morse="";
        for(String s :input){
            morse +=s+"   ";
        }
        etMorse.setText(morse+str);
    }
    //entfernt den letzten charakter
    private void removeLastChar() {
        str = str.substring(0, str.length() - 1);
    }
}
