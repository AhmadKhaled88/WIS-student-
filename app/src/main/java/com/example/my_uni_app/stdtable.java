package com.example.my_uni_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Selection;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

//import com.example.my_uni_app.databinding.ActivityStdinfoBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class stdtable extends AppCompatActivity {
    CheckBox c1,c2,c3,c4,c5,c6,c7;
    FirebaseAuth mAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    int i=0;
    Button select_item,dropButton;


    ArrayList<String> selection = new ArrayList<String>();
    TextView final_text ;
    private CheckForDB checkForDB ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stdtable);


       setTitle("السحب و الاضافة");



        c1=findViewById(R.id.check1);
        c2=findViewById(R.id.check2);
        c3=findViewById(R.id.check3);
        c4=findViewById(R.id.check4);
        c5=findViewById(R.id.check5);
        c6=findViewById(R.id.check6);
        c7=findViewById(R.id.check7);

        mAuth = FirebaseAuth.getInstance();

        checkForDB = new CheckForDB();


        String d1 = "   صفاء خالد الصرايرة         مهارات الحاسوب       0602095";
        String d2 = "0602110    أساسيات البرمجة     صلاح شامان الغيالين";
        String d3 = "0602120     تصميم المنطق الرقمي     رجاء محمد المساعدة";
        String d4 = "0602211     البرمجة الموجهة للكيانات     احمد عادل ابو شريحة";
        String d5 = "0602220     الرياضيات المتقطعة     نضال كامل العمري";
        String d6 = "0602302     الخوارزميات     صلاح شامان الغيالين";
        String d7 = "0603340     شبكات الحاسوب     عمر محمد المومني";


        select_item = findViewById(R.id.select_item);

        dropButton = findViewById(R.id.dropButton);



        reference=FirebaseDatabase.getInstance().getReference("user").child(mAuth.getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });


        select_item.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){

                startActivity(new Intent(stdtable.this, stdcourcetable.class));

                if (c1.isChecked()){
                    checkForDB.setCheck1(d1);
                    reference.child(String.valueOf(i)).setValue(checkForDB);
                }


                if (c2.isChecked()){
                    checkForDB.setCheck2(d2);
                    reference.child(String.valueOf(i)).setValue(checkForDB);
                }


                if (c3.isChecked()){
                    checkForDB.setCheck3(d3);
                    reference.child(String.valueOf(i)).setValue(checkForDB);
                }

                if (c4.isChecked()){
                    checkForDB.setCheck4(d4);
                    reference.child(String.valueOf(i)).setValue(checkForDB);
                }

                if (c5.isChecked()){
                    checkForDB.setCheck5(d5);
                    reference.child(String.valueOf(i)).setValue(checkForDB);
                }

                if (c6.isChecked()){
                    checkForDB.setCheck6(d6);
                    reference.child(String.valueOf(i)).setValue(checkForDB);
                }


                if (c7.isChecked()){
                    checkForDB.setCheck7(d7);
                    reference.child(String.valueOf(i)).setValue(checkForDB);
                }


            }
        });















    }

      }
