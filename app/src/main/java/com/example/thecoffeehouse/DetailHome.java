package com.example.thecoffeehouse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailHome extends AppCompatActivity {
    ImageView imgAvatarDetail, imgbackHome;
    TextView txtTitleDetail;
    TextView txtTextDetail;
    String playerTitle, playerText;
    Button buttonGo;
    int image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_home);

        imgbackHome = (ImageView) findViewById(R.id.gotoHome);
        buttonGo = (Button) findViewById(R.id.buttonGo);
        imgAvatarDetail = (ImageView) findViewById(R.id.imgAvatarDetail);
        txtTitleDetail = (TextView) findViewById(R.id.txtTitleDetail);
        txtTextDetail = (TextView) findViewById(R.id.txtTextDetail);

        playerTitle = getIntent().getStringExtra("title");
        playerText = getIntent().getStringExtra("text");
        image = getIntent().getIntExtra("image",0);

        txtTitleDetail.setText(playerTitle);
        txtTextDetail.setText(playerText);
        imgAvatarDetail.setImageResource(image);

        imgbackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailHome.this, Home.class);
                startActivity(intent);
            }
        });
        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailHome.this,orderScreen.class);
                startActivity(intent);
            }
        });
    }
}
