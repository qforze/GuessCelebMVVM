package com.loloc.guessceleb.data.repository;

import android.content.SharedPreferences;

import com.loloc.guessceleb.model.Horse;

public class Repository {

    public Horse loadHorse(String name) {
        //store it to shared prefs
        return new Horse();
    }

    public void saveHorse(Horse horse) {
        //load it from shared prefs
    }

}
