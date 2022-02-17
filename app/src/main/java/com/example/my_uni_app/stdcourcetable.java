package com.example.my_uni_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

public class stdcourcetable extends AppCompatActivity {

    FirebaseUser user;
    DatabaseReference databaseReference;
    String subjectID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stdcourcetable);

        setTitle("جدول الطالب");

        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("user");
        subjectID= user.getUid();


        final TextView subjects1TextView = (TextView) findViewById(R.id.subjects1);
        final TextView subjects2TextView = (TextView) findViewById(R.id.subjects2);
        final TextView subjects3TextView = (TextView) findViewById(R.id.subjects3);
        final TextView subjects4TextView = (TextView) findViewById(R.id.subjects4);
        final TextView subjects5TextView = (TextView) findViewById(R.id.subjects5);
        final TextView subjects6TextView = (TextView) findViewById(R.id.subjects6);
        final TextView subjects7TextView = (TextView) findViewById(R.id.subjects7);


        databaseReference.child(subjectID).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<DataSnapshot> task) {

                if (task.isSuccessful()) {

                    if (task.getResult().exists()) {

                        Toast.makeText(stdcourcetable.this, "تم تثبيت الجدول", Toast.LENGTH_SHORT).show();
                        DataSnapshot dataSnapshot = task.getResult();
                        String check1=String.valueOf(dataSnapshot.child("0").child("check1").getValue());
                        String check2=String.valueOf(dataSnapshot.child("0").child("check2").getValue());
                        String check3=String.valueOf(dataSnapshot.child("0").child("check3").getValue());
                        String check4=String.valueOf(dataSnapshot.child("0").child("check4").getValue());
                        String check5=String.valueOf(dataSnapshot.child("0").child("check5").getValue());
                        String check6=String.valueOf(dataSnapshot.child("0").child("check6").getValue());
                        String check7=String.valueOf(dataSnapshot.child("0").child("check7").getValue());

                        subjects1TextView.setText(check1);
                        subjects2TextView.setText(check2);
                        subjects3TextView.setText(check3);
                        subjects4TextView.setText(check4);
                        subjects5TextView.setText(check5);
                        subjects6TextView.setText(check6);
                        subjects7TextView.setText(check7);


                    }

                }
            }
        });



    }
}