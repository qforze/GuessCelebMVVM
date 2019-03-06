package com.loloc.guessceleb.ui.settings;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.loloc.guessceleb.R;
import com.loloc.guessceleb.data.repository.Repository;
import com.loloc.guessceleb.model.Horse;

public class Settings extends AppCompatActivity {

    private SettingsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        viewModel = ViewModelProviders.of(this).get(SettingsViewModel.class);

        String serialized = getIntent().getExtras().getString("horse");
        Horse cavalier = Horse.fromJson(serialized);

/*
        Repository repository = new Repository();

        Horse cavalier = repository.loadHorse("cavalier");
        cavalier.age = 8;
        cavalier.setWeight(600);

        String serialized = cavalier.toJson();
        Intent intent = new Intent(this, Settings.class);
        intent.putExtra("horse", serialized);
        startActivity(intent);*/


    }

}
