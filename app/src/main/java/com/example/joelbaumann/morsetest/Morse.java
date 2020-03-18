package com.example.joelbaumann.morsetest;

import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class Morse{

    //Buchstaben Array
    String[] letterArray = new String[]{" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "Ä", "È", "É", "Ö", "Ü", ",", ":", ";", "?", "@"};
    //Morsezeichen Array
    String[] morseArray = new String[]{"|", "•─", "─•••", "─•─•", "─••", "•", "••─•", "──•", "••••", "••", "•───", "─•─", "•─••", "──", "─•", "───", "•──•", "──•─", "•─•", "•••", "─", "••─", "•••─", "•──", "─••─", "─•──", "──••", "•────", "••───", "•••──", "••••─", "•••••", "─••••", "──•••", "───••", "────•", "─────", "•─•─", "•─••─", "••─••", "───•", "••──", "──••──", "───•••", "─•─•─•", "••──••", "•──•─•"};


    //Konventiert einen Text zu Morsezeichen
    public String convertToMorse(String text){

        String str="";
        List<String> textList = asList(letterArray);

        for(int i = 0;i< text.length();i++){
            char c = Character.toUpperCase(text.charAt(i));
            int index =textList.indexOf(Character.toString(c));
            //Baut einen Text aus den dazugehörigen Morsezeichen
            str += morseArray[index]+"   ";
        }
       return(str);
    }
    //Konventiert einen Morsezeichen zu Text
    public String convertToText(ArrayList<String> list){
        String str="";
        List<String> morseList = asList(morseArray);

        for(int i = 0;i< list.size();i++){

            int index = morseList.indexOf(list.get(i));

            //Baut einen Text zusammen
            str += letterArray[index];
        }
        return(str);



    }

    //überprüft ob der eingegebene Morsecode den Vorgaben entspricht
    public boolean checkMorse(ArrayList<String> morse){

        Boolean checker = true;
        List morseList = Arrays.asList(morseArray);
        for(String s : morse){
            if(!morseList.contains(s)){
                checker = false;
            }
        }
        return checker;
    }
    //überprüft ob der Text keine invaliden zeichen enthält
    public boolean checkText(String text){
        Boolean checker = false;
        List<String> textList = asList(letterArray);
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
