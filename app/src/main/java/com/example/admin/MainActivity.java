package com.example.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    CardView UploadNotice , addPDF , DeleteNotice, addstd ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       addstd=findViewById(R.id.addstd);
       addstd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               switch (view.getId()){

                   case R.id.addstd:
                       Intent intent = new Intent(MainActivity.this,addstd.class);
                       startActivity(intent);
                       break;
               }
           }
       });
        
        UploadNotice = findViewById(R.id.addNotice);
        UploadNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){

                    case R.id.addNotice:
                        Intent intent = new Intent(MainActivity.this,uploadnotice.class);
                        startActivity(intent);
                        break;
                                  }
            }
        });



        DeleteNotice = findViewById(R.id.DeleteNotice);
        DeleteNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,DeleteNoticeActivity.class));

            }
        });



        addPDF=findViewById(R.id.addpdf);
        addPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,the_major.class));
            }
        });




    }
}