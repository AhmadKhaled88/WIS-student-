package com.example.my_uni_app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my_uni_app.databinding.ActivityStdinfoBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.NotNull;

import java.util.ArrayList;

public class stdinfo extends AppCompatActivity {
    // creating variables for our list view.
    FirebaseUser user;

    DatabaseReference databaseReference;
    String userID;
    Button button;
    ActivityStdinfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stdinfo);

        setTitle("معلومات الطالب");

        binding = ActivityStdinfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("user");
        userID = user.getUid();

        final TextView NameTextView = (TextView) findViewById(R.id.Name_user);
        final TextView IDTextView = (TextView) findViewById(R.id.ID_user);
        final TextView EmailTextView = (TextView) findViewById(R.id.Email_user);
        final  TextView MajorTextView=(TextView)findViewById(R.id.major_user);

        databaseReference.child(userID).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {


            @Override
            public void onComplete(@NonNull @NotNull Task<DataSnapshot> task) {

                if (task.isSuccessful()) {

                    if (task.getResult().exists()) {


                        Toast.makeText(stdinfo.this, "Successfully Read", Toast.LENGTH_SHORT).show();

                        DataSnapshot dataSnapshot = task.getResult();
                        String major =String.valueOf(dataSnapshot.child("major").getValue());
                        String email = String.valueOf(dataSnapshot.child("email").getValue());
                        String id = String.valueOf(dataSnapshot.child("id").getValue());
                        String name = String.valueOf(dataSnapshot.child("name").getValue());
                        NameTextView.setText(name);
                        IDTextView.setText(id);
                        EmailTextView.setText(email);
                        MajorTextView.setText(major);
                    }
                }
            }
        });




    }
}

