package com.example.my_uni_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class cs extends AppCompatActivity {

    GridView gridView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.wise)));
        getSupportActionBar().setTitle("Computer Science");

        gridView1 = findViewById(R.id.doclist);
        ArrayList<doc> arrayList = new ArrayList<>();
        arrayList.add(new doc(R.drawable.aadl, "عادل حمدان", "أستاذ مشارك"));
        arrayList.add(new doc(R.drawable.ali, "علي محمد الابراهيم", "أستاذ مشارك"));
        arrayList.add(new doc(R.drawable.salahpic_0, "صلاح الغيالين", "أستاذ مساعد"));
        arrayList.add(new doc(R.drawable.lila, "ليلى محمد القيسي", "مدرس"));
        arrayList.add(new doc(R.drawable.sadek, "الدكتور صادق الحموز", "أستاذ "));
        arrayList.add(new doc(R.drawable.professor, "رجاء المساعده", "أستاذ مساعد"));
        arrayList.add(new doc(R.drawable.professor, "د. نسرين الشرمان", "أستاذ مساعد"));
        arrayList.add(new doc(R.drawable.professor, "م. خلود شقيرات", "مدرس"));
        arrayList.add(new doc(R.drawable.professor, "د. شيماء المساعدة", "مدرس"));
        arrayList.add(new doc(R.drawable.nour, "نور القضاة", ""));
        DocAdapter docAdapter =new DocAdapter(this,R.layout.list_view_cs,arrayList);
        gridView1.setAdapter(docAdapter);



        TextView textView = (TextView) findViewById(R.id.csss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

    }
}