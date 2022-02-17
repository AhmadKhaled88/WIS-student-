package com.example.my_uni_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class University_calendar extends AppCompatActivity {

    private RecyclerView calendarRecycler;
    private DatabaseReference reference;
    private List<University_calendar_data>list;
    private University_calendar_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_calendar);


        setTitle("التقويم الجامعي");

        calendarRecycler=findViewById(R.id.calendarRecycler);
        reference= FirebaseDatabase.getInstance().getReference().child("pdf");
        
        getData();

    }

    private void getData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {

                list = new ArrayList<>();
                   for (DataSnapshot snapshot1 : snapshot.getChildren()){

                       University_calendar_data data=snapshot1.getValue(University_calendar_data.class);
                       list.add(data);
                   }
                   adapter=new University_calendar_adapter(University_calendar.this,list);
                   calendarRecycler.setLayoutManager(new LinearLayoutManager(University_calendar.this));
                   calendarRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(University_calendar.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}