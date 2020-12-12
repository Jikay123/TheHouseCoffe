package com.example.thecoffeehouse;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static android.os.SystemClock.sleep;

public class splash extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                sleep(3000);
                Intent i = new Intent(splash.this, Home.class);
                startActivity(i);
            }
        });
        thread.start();
    }
}
