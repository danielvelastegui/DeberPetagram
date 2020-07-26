package com.danielvelastegui.deberpetagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class About extends AppCompatActivity {

    private Toolbar aboutToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        aboutToolBar = findViewById(R.id.aboutToolbar);
        setSupportActionBar(aboutToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}