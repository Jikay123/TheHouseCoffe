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

public class Register extends AppCompatActivity {
    private Button register;
    private TextView txt_login;
    private FirebaseAuth mAuth;
    private EditText edtEmail;
    private  EditText edtPass, edtRepass;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register = (Button) findViewById(R.id.button_sigup);
        txt_login = (TextView) findViewById(R.id.txt_login);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPass = (EditText) findViewById(R.id.edtPass);
        edtRepass = (EditText) findViewById(R.id.edtRepass);
        mAuth = FirebaseAuth.getInstance();

     register.setOnClickListener(new View.OnClickListener() {

         @Override
         public void onClick(View v) {

             if(edtPass.getText().toString().equalsIgnoreCase(edtRepass.getText().toString())){

                 Register(edtEmail.getText().toString(),edtPass.getText().toString());
                 Intent intent = new Intent(Register.this, Home.class);
                 startActivity(intent);

             }else {
                 Toast.makeText(Register.this, "Nhập lại mật khẩu không trùng!", Toast.LENGTH_SHORT).show();
             }

         }
     });


     txt_login.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(Register.this, Login.class);
             startActivity(intent);
         }
     });
    }

    void Register(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(Register.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }
    void loginSuccess() {

    }

    private void updateUI(FirebaseUser user) {

    }
}
