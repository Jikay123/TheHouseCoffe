package com.example.thecoffeehouse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Notification extends AppCompatActivity {
    private ImageView img_close,imgListNotification;
    private Button backToHome;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        img_close = (ImageView) findViewById(R.id.drawn_close);
        imgListNotification = (ImageView)findViewById(R.id.list_notification);
        backToHome = (Button) findViewById(R.id.backToHome);
        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Notification.this, Home.class);
                startActivity(intent);
            }
        });
    }
}
