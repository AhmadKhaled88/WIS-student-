package com.example.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class addstd extends AppCompatActivity  {

    EditText Email, Password, Name,ID,Major;
    Button BackLogin;
    FirebaseAuth mAuth;
    TextView TBackToLogin,banner;
    FirebaseDatabase firebaseDatabase;
    private ProgressDialog pd ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addstd);
         this.setTitle("ADD STUDENT");
        pd = new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        Email=findViewById(R.id.RStudentEmail);
        Password=findViewById(R.id.RStudentPassword);
        Name=findViewById(R.id.stdName);
        ID=findViewById(R.id.stdID);
        Major=findViewById(R.id.stdmajor);

        BackLogin=findViewById(R.id.BackLogin);
        BackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

    }




    private void registerUser() {
        pd.setTitle("Please wait...");
        pd.setMessage("Uploading the student information");
        pd.show();
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
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    pd.dismiss();
                    User user=new User(StudentName,StudentID,StudentEmail,StudentMajor);
                    firebaseDatabase.getInstance().getReference("user").child(mAuth.getInstance().getCurrentUser().getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull  Task<Void> task) {
                            if (task.isSuccessful()){
                                pd.dismiss();
                                Toast.makeText(addstd.this,"Registered Successfully !",Toast.LENGTH_LONG).show();
                            }
                            else {
                                pd.dismiss();
                                Toast.makeText(addstd.this,"Failed to Registered ! Try again",Toast.LENGTH_LONG).show();


                            }
                        }
                    });


                }else {
                    pd.dismiss();
                    Toast.makeText(addstd.this,"Failed to Registered ",Toast.LENGTH_LONG).show();


                }
            }
        });



    }
}