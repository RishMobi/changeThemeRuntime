package com.example.themechange;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ActivityA extends AppCompatActivity {
    private int theme;
    private TextView textView;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("Shared",MODE_PRIVATE);
        theme = sharedPreferences.getInt("Theme",R.style.AppTheme);
        setTheme(theme);
        setContentView(R.layout.activity_a);
        textView = findViewById(R.id.textView);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                if (theme == R.style.AppTheme)
                    sharedPreferences.edit().putInt("Theme",R.style.AppTheme2).apply();
                else
                    sharedPreferences.edit().putInt("Theme",R.style.AppTheme).apply();
                finish();
                startActivity(getIntent());
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
    }

}
