package com.example.my_uni_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class cn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cn);

        TextView textView= (TextView) findViewById(R.id.cns);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}