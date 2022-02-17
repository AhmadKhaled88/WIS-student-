package com.example.my_uni_app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class cn extends AppCompatActivity {

    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cn);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.wise)));
        getSupportActionBar().setTitle("Information Systems and Networks");

        TextView textView= (TextView) findViewById(R.id.cns);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        gridView = findViewById(R.id.listviewcn);
        ArrayList<doc> arrayList = new ArrayList<>();
        arrayList.add(new doc(R.drawable.jafar, "جعفر \"محمد علي\" عبابنة", "أستاذ مشارك"));
        arrayList.add(new doc(R.drawable.omarmomani1, "عمر المومني", "أستاذ مشارك"));
        arrayList.add(new doc(R.drawable.professor, "أديب منصور فلاح السعايدة", "أستاذ مساعد"));
        arrayList.add(new doc(R.drawable.bklezi, "محمود خالد بكليزي", "أستاذ مشارك"));
        arrayList.add(new doc(R.drawable.ahmadfraihat, "احمد الفريحات", "أستاذ مساعد"));
        arrayList.add(new doc(R.drawable.professor, "د.سامي الصمادي", "أستاذ مساعد"));
        arrayList.add(new doc(R.drawable.professor, "د.محمد الشلبي", "أستاذ مساعد"));
        arrayList.add(new doc(R.drawable.professor, "د.فراس الزعبي", "أأستاذ مساعد"));
        DocAdapter docAdapter =new DocAdapter(this,R.layout.list_view_cs,arrayList);
        gridView.setAdapter(docAdapter);
    }
}