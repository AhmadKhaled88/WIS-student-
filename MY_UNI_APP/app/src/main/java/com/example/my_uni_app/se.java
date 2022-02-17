package com.example.my_uni_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class se extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_se);
        TextView textView= (TextView) findViewById(R.id.ses);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}