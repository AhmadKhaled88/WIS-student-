package com.example.my_uni_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class It extends AppCompatActivity implements View.OnClickListener {
    CardView cardView1,cardView2,cardView3,cardView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it);
        cardView1 = findViewById(R.id.cardit1);
        cardView2 = findViewById(R.id.cardit2);
        cardView3 = findViewById(R.id.cardit3);
        cardView4 = findViewById(R.id.cardit4);

        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);
        cardView3.setOnClickListener(this);
        cardView4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent v;
        switch (view.getId()){
            case R.id.cardit1:
                v = new Intent (view.getContext(),cs.class) ;
                startActivity(v);
                break;
            case R.id.cardit2:
                v = new Intent (view.getContext(),se.class) ;
                startActivity(v);
                break;
            case R.id.cardit3:
                v = new Intent (view.getContext(),cn.class) ;
                startActivity(v);
                break;
            case R.id.cardit4:
                v = new Intent (view.getContext(),sn.class) ;
                startActivity(v);
                break;
        }

    }
}