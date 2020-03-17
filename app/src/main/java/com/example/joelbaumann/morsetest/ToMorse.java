package com.example.joelbaumann.morsetest;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class ToMorse extends AppCompatActivity {

    Morse morse = new Morse();
    //input
    EditText etText;
    //output
    EditText etOutput;
    TextView tvError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_morse);
        setTitle("To Morse");
        etText = (EditText) findViewById(R.id.etText);
        etText.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(etText, InputMethodManager.SHOW_IMPLICIT);
        etOutput = (EditText) findViewById(R.id.etOutput);
        tvError = (TextView) findViewById(R.id.tvError);
        tvError.setVisibility(View.INVISIBLE);


    }

    //setzt den input auf Morse
    public void convertToMorse(View view) {
        String input = etText.getText().toString();
        if (morse.checkText(input)) {
            tvError.setVisibility(View.INVISIBLE);
            etOutput.setText(morse.convertToMorse(input));
        } else {
            //setzt error und cleared das Eingabefeld
            tvError.setVisibility(View.VISIBLE);
            etOutput.setText("");
        }

    }

    /*@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (maxHeight > 0){
            int hSize = MeasureSpec.getSize(heightMeasureSpec);
            int hMode = MeasureSpec.getMode(heightMeasureSpec);

            switch (hMode){
                case MeasureSpec.AT_MOST:
                    heightMeasureSpec = MeasureSpec.makeMeasureSpec(Math.min(hSize, maxHeight), MeasureSpec.AT_MOST);
                    break;
                case MeasureSpec.UNSPECIFIED:
                    heightMeasureSpec = MeasureSpec.makeMeasureSpec(maxHeight, MeasureSpec.AT_MOST);
                    break;
                case MeasureSpec.EXACTLY:
                    heightMeasureSpec = MeasureSpec.makeMeasureSpec(Math.min(hSize, maxHeight), MeasureSpec.EXACTLY);
                    break;
            }
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }*/

}
