package com.artemzin.screenvalley.sample.simple.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.artemzin.screenvalley.ScreenValley;
import com.artemzin.screenvalley.sample.simple.ui.screens.LoginScreen;

public class TheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScreenValley screenValley = ScreenValley
                .builder()
                .activity(this)
                .previousState(savedInstanceState)
                .build();

        screenValley.showScreen(new LoginScreen(screenValley));
    }
}
