package com.example.my_uni_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegisteActivity extends AppCompatActivity implements View.OnClickListener{

    EditText Email, Password, Name,ID,Major;
    Button BackLogin;
    FirebaseAuth mAuth;
    TextView TBackToLogin,banner;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registe);


        mAuth=FirebaseAuth.getInstance();

        banner=findViewById(R.id.banner);
        banner.setOnClickListener(this);


        BackLogin=findViewById(R.id.BackLogin);
        BackLogin.setOnClickListener(this);

        Email=findViewById(R.id.RStudentEmail);
        Password=findViewById(R.id.RStudentPassword);
        Name=findViewById(R.id.stdName);
        ID=findViewById(R.id.stdID);
        Major=findViewById(R.id.stdmajor);





    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.banner:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.BackLogin:
                registerUser();
                break;
        }


    }

    private void registerUser() {
        String StudentName=Name.getText().toString().trim();
        String StudentID=ID.getText().toString().trim();
        String StudentEmail=Email.getText().toString().trim();
        String StudentPassword=Password.getText().toString().trim();
        String StudentMajor=Major.getText().toString().trim();

        if (StudentName.isEmpty()){
            Name.setError("Student Name is Required !");
            Name.requestFocus();
            return;
        }
        if (StudentID.isEmpty()){
            ID.setError("Student ID is Required !");
            ID.requestFocus();
            return;
        }

        if (StudentEmail.isEmpty()){
            Email.setError("Student Email is Required !");
            Email.requestFocus();
            return;
        }

        if (StudentPassword.isEmpty()){
            Password.setError("Student Password is Required !");
            Password.requestFocus();
            return;
        }
        if (StudentPassword.length()<6){
            Password.setError("Minimum Password length Should be 6 characters !");
            Password.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(StudentEmail,StudentPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull  Task<AuthResult> task) {
                if (task.isSuccessful()){
                    User user=new User(StudentName,StudentID,StudentEmail,StudentMajor);
                    firebaseDatabase.getInstance().getReference("user").child(mAuth.getInstance().getCurrentUser().getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull  Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(RegisteActivity.this,"Registered Successfully !",Toast.LENGTH_LONG).show();
                            }
                            else {
                                Toast.makeText(RegisteActivity.this,"Failed to Registered ! Try again",Toast.LENGTH_LONG).show();


                            }
                        }
                    });


                }else {
                    Toast.makeText(RegisteActivity.this,"Failed to Registered ",Toast.LENGTH_LONG).show();


                }
            }
        });



    }


   // public void BackLOG(View view) {
       // startActivity(new Intent(RegisteActivity.this, MainActivity.class));

    //}
}