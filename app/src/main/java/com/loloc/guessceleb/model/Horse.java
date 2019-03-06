package com.loloc.guessceleb.model;

import com.google.gson.Gson;

public class Horse {

    public void setWeight(int weight) {
        if (weight > 3000 || weight < 0) {
            throw new RuntimeException("Wrong weight");
        }
        this.weight = weight;
    }



    public int getWeight() {
        return weight;
    }

    private int weight = 0;
    public int age = 0;

    public int calculateHumanYears() {
        return age * 7;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

    public static Horse fromJson(String json) {
        return new Gson().fromJson(json, Horse.class);
    }
}
