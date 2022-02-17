package com.example.my_uni_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisteActivity extends AppCompatActivity {
    EditText rStudentEmail,rStudentPassword;
    Button BackLogin;
    FirebaseAuth mUTH;
    TextView TBackToLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registe);

        rStudentPassword=findViewById(R.id.RStudentPassword);
        rStudentEmail=findViewById(R.id.RStudentEmail);
        BackLogin=findViewById(R.id.BackLogin);
        TBackToLogin=findViewById(R.id.BackToLogin);


        //Firebase for Register
        mUTH=FirebaseAuth.getInstance();


    }

    public void BackLOG(View view) {
        startActivity(new Intent(RegisteActivity.this,LoginPage.class));
    }


    // Button Register
    public void Rebutton(View view) {
        creatUser();
    }
    public void creatUser(){
        String StudentEmail=rStudentEmail.getText().toString();
        String StudentPassword=rStudentPassword.getText().toString();


        if (TextUtils.isEmpty(StudentEmail)){
            rStudentEmail.setError("Email Cont Be empty !!");
            rStudentEmail.requestFocus();

        }else if (TextUtils.isEmpty(StudentPassword)){

            rStudentPassword.setError("Pass Cont Be empty !!");
            rStudentPassword.requestFocus();
        }else {
            mUTH.createUserWithEmailAndPassword(StudentEmail,StudentPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(RegisteActivity.this, "Register Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisteActivity.this,LoginPage.class));
                    } else {
                        Toast.makeText(RegisteActivity.this, " Register Error " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }


            });
        }
    }

    }
