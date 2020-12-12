package com.example.thecoffeehouse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {
    private DatabaseReference mDatabase;
// ...
    FirebaseAuth mAuth;
    private Button button_login;
    private TextView txt_register;
    private EditText edtEmail,edtPass;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        button_login = (Button) findViewById(R.id.button_login);
        txt_register = (TextView) findViewById(R.id.txt_register);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPass = (EditText) findViewById(R.id.edtPass);
        mAuth = FirebaseAuth.getInstance();

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mDatabase.child("Profile").child("Ten").setValue("Nguyen Long");
//                Toast.makeText(Login.this, "GG", Toast.LENGTH_SHORT).show();
                if (edtEmail.getText().toString().isEmpty() && edtPass.getText().toString().isEmpty()){
                    Toast.makeText(Login.this, "Nhập thiếu dữ liệu", Toast.LENGTH_SHORT).show();
                }else {
                    login(edtEmail.getText().toString(), edtPass.getText().toString());
                    Intent intent = new Intent(Login.this, Home.class);
                    startActivity(intent);
                }
            }
        });
        txt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });

        //Đăng nhập ẩn button login

    }
    private void writeNewUser() {

        mDatabase.child("Profile").child("Ten").setValue("gg");
    }

    void login(String email, String password){

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(Login.this, "Action Success", Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(Login.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);

                        }

                    }
                });
    }

    private void updateUI(FirebaseUser user) {
    }

}
