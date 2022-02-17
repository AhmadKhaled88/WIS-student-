package com.example.my_uni_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class se extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_se);
        TextView textView= (TextView) findViewById(R.id.ses);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        gridView = findViewById(R.id.doclistse);
        ArrayList<doc> arrayList2 = new ArrayList<>();
        arrayList2.add(new doc(R.drawable.issa, "عيسى علي فلاح عتوم", "أستاذ مشارك"));
        arrayList2.add(new doc(R.drawable.nidal, "نضال كامل طه العمري ", "أستاذ مشارك"));
        arrayList2.add(new doc(R.drawable.eman, "إيمان محمد نعيم ياسين", "مدرس"));
        arrayList2.add(new doc(R.drawable.alin, "علي محمد نعيمات", "أستاذ مساعد"));
        arrayList2.add(new doc(R.drawable.alotam, "معاذ حسني الطراونة", "أستاذ مساعد"));
        arrayList2.add(new doc(R.drawable.sfaa, "صفاء الصرايرة", "مدرس"));
        arrayList2.add(new doc(R.drawable.heshamkrabsha, "هشام الخرابشة", "مدرس"));
        arrayList2.add(new doc(R.drawable.untited, "د. حسن أبو العيس", "أستاذ ممساعد"));
        arrayList2.add(new doc(R.drawable.untited, "مالك المومني", "أستاذ مساعد"));
        DocAdapter docAdapter =new DocAdapter(this,R.layout.list_view_cs,arrayList2);
        gridView.setAdapter(docAdapter);


    }
}