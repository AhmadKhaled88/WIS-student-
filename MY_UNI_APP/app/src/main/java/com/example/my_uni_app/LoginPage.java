package com.example.my_uni_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {


    FirebaseAuth mAuth;
    EditText et_username,et_password;
    Button login_button ;
    TextView Forgetten_password;
    TextView Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);


        et_username = findViewById(R.id.etLoginEmail);
        et_password = findViewById(R.id.etLoginPass);
        login_button = findViewById(R.id.btnLogin);
        Forgetten_password = findViewById(R.id.tvpass);
        Register=findViewById(R.id.Register);
        mAuth = FirebaseAuth.getInstance();

        Register.setOnClickListener(view ->{
            startActivity(new Intent(LoginPage.this,RegisteActivity.class));
        } );


        login_button.setOnClickListener(view -> {
            loginUser();
        });


        //tvRegisterHere.setOnClickListener(view ->{
        // startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        // });
    }

    private void loginUser(){
        String email = et_username.getText().toString();
        String password = et_password.getText().toString();

        if (TextUtils.isEmpty(email)){
            et_username.setError("Email cannot be empty");
            et_username.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            et_password.setError("Password cannot be empty");
            et_password.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(LoginPage.this, "YOU WELCOME", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginPage.this, MainActivity.class));
                    }else{
                        Toast.makeText(LoginPage.this, "Login Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        int Id = item.getItemId();


        if (Id == R.id.nav_logout) {

            Intent intent = new Intent(LoginPage.this, LOGOUT.class);
            startActivity(intent);

            return true;
        }

        return false;
    }

}

