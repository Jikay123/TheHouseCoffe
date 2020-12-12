package com.example.thecoffeehouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class account_screen extends AppCompatActivity {
    private Button buttonLogout;
    private FirebaseUser user;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_account_screen);
        textView = (TextView) findViewById(R.id.txtemail);
        buttonLogout = (Button) findViewById(R.id.buttonlogout);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null)  //Nếu chưa đăng nhập, user rỗng
            {
                // Name, email address, and profile photo Url
                String name = user.getDisplayName();
                String email = user.getEmail();

                // Check if user's email is verified


            }else{
            buttonLogout.setVisibility(View.GONE);
        }

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(account_screen.this, "Cliked", Toast.LENGTH_SHORT).show();
                mAuth.signOut();
                Intent intent=new Intent(account_screen.this, Home.class);
                startActivity(intent);
            }
        });
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.account);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.news:
                        startActivity(new Intent(getApplicationContext(),Home.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.delivery:
                        startActivity(new Intent(getApplicationContext(),orderScreen.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.store:
                        startActivity(new Intent(getApplicationContext(),store_screen.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.account:
//                        startActivity(new Intent(getApplicationContext(),account_screen.class));
//                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}