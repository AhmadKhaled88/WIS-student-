package com.example.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.annotations.NotNull;

public class LoginPage extends AppCompatActivity {

    EditText etLoginEmail;
    EditText etLoginPassword;
    TextView tvpass , Adminpage;
    Button btnLogin;

    FirebaseAuth mAuth;
    EditText et_username,et_password;
    Button login_button ;
    TextView Forgetten_password;
    TextView Register;

    private View decorView;

    private TextView txtviewresault;
    private EditText textinput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);


        txtviewresault = findViewById(R.id.etLoginEmail);
        textinput = findViewById(R.id.etLoginPass);


        tvpass = findViewById(R.id.tvpass);

        tvpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ResetMail=new EditText(v.getContext());
                AlertDialog.Builder PassWordResetDialog=new AlertDialog.Builder(v.getContext());
                PassWordResetDialog.setTitle("Reset Password ?");
                PassWordResetDialog.setMessage("Enter Your Email ");
                PassWordResetDialog.setView(ResetMail);

                PassWordResetDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String mail=ResetMail.getText().toString();
                        mAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(LoginPage.this,"Reset Link Sent To Your Email ",Toast.LENGTH_LONG).show();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull @NotNull Exception e) {
                                Toast.makeText(LoginPage.this,"Error ! Reset Link is Not Sent "+e.getMessage(),Toast.LENGTH_LONG).show();

                            }
                        });

                    }
                });
                PassWordResetDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                PassWordResetDialog.create().show();
            }
        });

        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if (visibility == 0){

                    decorView.setSystemUiVisibility(hideSystemBare());
                }
            }
        });



        et_username = findViewById(R.id.etLoginEmail);
        et_password = findViewById(R.id.etLoginPass);
        login_button = findViewById(R.id.btnLogin);
        Forgetten_password = findViewById(R.id.tvpass);
        mAuth = FirebaseAuth.getInstance();



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
    public void onWindowFocusChanged(boolean hasFocus){
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {

            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    |View.SYSTEM_UI_FLAG_FULLSCREEN
                    |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    |View.SYSTEM_UI_FLAG_FULLSCREEN
                    |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION );


        }
    }
    private int hideSystemBare(){

        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                |View.SYSTEM_UI_FLAG_FULLSCREEN
                |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                |View.SYSTEM_UI_FLAG_FULLSCREEN
                |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION ;

    }

    public void setText(View view) {

        String newText = textinput.getText().toString();
        txtviewresault.setText(newText);

        closeKeyboard();
    }

    private void closeKeyboard(){

        View view = this.getCurrentFocus();
        if (view != null) {

            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

            imm.hideSoftInputFromWindow(view.getWindowToken(),0);

        }


    }
}

