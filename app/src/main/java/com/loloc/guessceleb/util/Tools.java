package com.loloc.guessceleb.util;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tools {

    static int questionsAnsweredStatic = 0;
    int questionsAnswered = 0;

    public ArrayList<String> getListFromHtml(String pattern, String source){
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(source);
        ArrayList<String> temp = new ArrayList<>();
        while (m.find()) {
            temp.add(m.group(1));
        }
        return temp;
    }

    public static ArrayList<String> getListFromHtmlStatic(String pattern, String source){
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(source);
        ArrayList<String> temp = new ArrayList<>();
        while (m.find()) {
            temp.add(m.group(1));
        }
        return temp;
    }


    public static void questionAnsweredStatic(){
        questionsAnsweredStatic ++;
    }

    public static int howManyAnsweredStatic(){
        return questionsAnsweredStatic;
    }


    public void questionAnswered(){
        questionsAnswered ++;
    }

    public int howManyAnswered(){
        return questionsAnswered;
    }

}
