package com.loloc.guessceleb;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.loloc.guessceleb.util.Tools;

import java.util.ArrayList;
import java.util.Random;

public class MainViewModel extends ViewModel {

    private Tools tools = new Tools();

    int correctAnswer = 0;
    MutableLiveData<String> imageUrl = new MutableLiveData<>();
    MutableLiveData<ArrayList<String>> buttonNames = new MutableLiveData<>();
    MutableLiveData<String> showToast = new MutableLiveData<>();

    ArrayList<String> names;
    ArrayList<String> pictures;

    void loadData(Context context){
        Ion.with(context).load("https://www.imdb.com/list/ls052283250/").asString().setCallback(new FutureCallback<String>() {
            @Override
            public void onCompleted(Exception e, String result) {
                names = tools.getListFromHtml("pst\"\n" +
                        "> <img alt=\"(.*?)\"", result);
                pictures = Tools.getListFromHtmlStatic("src=\"(.*?)\"\n" +
                        "width=\"", result);
                nextTry();
            }
        });
    }

    void buttonClicked(int tag){
        if (tag == correctAnswer) {
            showToast.postValue("Correct!");
        } else {
            showToast.postValue("Wrong!");
        }
        nextTry();
    }

    void names(String urlName, ArrayList<String> names) {
        ArrayList<String> nameList = new ArrayList<>();
        correctAnswer = new Random().nextInt(4);
        for (int i = 0; i < 4; i++) {
            if (i == correctAnswer) {
                nameList.add(urlName);
            } else {
                int index = new Random().nextInt(names.size());
                String randomName = names.get(index);
                nameList.add(randomName);
            }
        }
        buttonNames.postValue(nameList);
    }

    void nextTry() {
        int index = new Random().nextInt(pictures.size());
        String urlImage = pictures.get(index);
        imageUrl.postValue(urlImage);
        String urlName = names.get(index);
        names(urlName, names);
    }

}
