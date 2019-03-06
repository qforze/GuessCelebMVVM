package com.loloc.guessceleb;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.koushikdutta.ion.Ion;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button settings;
    Button buttons[];
    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        viewModel.imageUrl.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                ImageView imageView = findViewById(R.id.imageView);
                Ion.with(MainActivity.this).load(s).intoImageView(imageView);
            }
        });

        viewModel.showToast.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });

        viewModel.buttonNames.observe(this, new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(@Nullable ArrayList<String> s) {
                if (s != null) {
                    ((TextView)findViewById(R.id.button1)).setText(s.get(0));
                    ((TextView)findViewById(R.id.button2)).setText(s.get(1));
                    ((TextView)findViewById(R.id.button3)).setText(s.get(2));
                    ((TextView)findViewById(R.id.button4)).setText(s.get(3));
                }
            }
        });
        viewModel.loadData(this);
    }

    public void onClick(View view) {
        String tag = view.getTag().toString();
        viewModel.buttonClicked(Integer.parseInt(tag));
    }
}