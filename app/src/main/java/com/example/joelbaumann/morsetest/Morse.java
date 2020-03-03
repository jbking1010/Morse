package com.example.joelbaumann.morsetest;

import android.widget.EditText;

import java.util.Arrays;
import java.util.List;

public class Morse{

    /*MainActivity main;
    public Morse(MainActivity main){
        this.main = main;
    }*/

    String[] letterArray = new String[]{" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "Ä", "È", "É", "Ö", "Ü", ",", ":", ";", "?", "@"};
    String[] morseArray = new String[]{"|", "•–", "–•••", "–•–•", "–••", "•", "••–•", "––•", "••••", "••", "•–––", "–•–", "•–••", "––", "–•", "–––", "•––•", "––•–", "•–•", "•••", "–", "••–", "•••–", "•––", "–••–", "–•––", "––••", "•––––", "••–––", "•••––", "••••–", "•••••", "–••••", "––•••", "–––••", "––––•", "–––––", "•–•–", "•–••–", "••–••", "–––•", "••––", "––••––", "–––•••", "–•–•–•", "••––••", "•––•–•"};

    //EditText text = main.findViewById(R.id.txtText);
    //EditText morse = main.findViewById(R.id.txt_morse);
    public String convertToMorse(String text){

        String str="";
        List<String> textList = Arrays.asList(letterArray);

        for(int i = 0;i< text.length();i++){
            char c = Character.toUpperCase(text.charAt(i));
            int index =textList.indexOf(Character.toString(c));

            str += morseArray[index]+"   ";
        }
       return(str);

    }
    public void convertToText(String morse){



    }
    public void getMorse(){

    }
    public void getText(){

    }
    public boolean checkMorse(String morse){
        //if(morse.matches("[|•–]")){
        if(morse.matches("[|.-]")){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean checkText(String text){
        Boolean checker = false;
        List<String> textList = Arrays.asList(letterArray);
        for(char c: text.toCharArray()){
            c = Character.toUpperCase(c);
            if (textList.contains(Character.toString(c))){
                checker = true;}
            else{
                checker=false;
                return checker;
            }
        }
        return checker;
    }
}
