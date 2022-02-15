package com.example.admin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class uploadnotice extends AppCompatActivity {

    private CardView addImage ;
    private final int REQ = 1 ;
    private Bitmap bitmap ;
    private ImageView noticeImageView ;
    private EditText noticeTitle ;
    private Button uploadNoticebtn ;

    private DatabaseReference reference ;
    private StorageReference storageReference;

    String downloadUrl = "NoticeData" ;

    private ProgressDialog pd ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadnotice);

         this.setTitle("ADD NOTICE");

        reference = FirebaseDatabase.getInstance().getReference();
        storageReference = FirebaseStorage.getInstance().getReference();

        pd = new ProgressDialog(this);



        noticeTitle = findViewById(R.id.noticeTitle);

        uploadNoticebtn = findViewById(R.id.uploadNoticebtn);

        uploadNoticebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (noticeTitle.getText().toString().isEmpty()){
                    noticeTitle.setError("Empty");
                    noticeTitle.requestFocus();
                }

                else if (bitmap == null){
                    uploadData();
                } else {
                    uploadImage();
                }
            }


            private void uploadImage() {

                pd.setMessage("Uploading ...");
                pd.show();

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,50,baos);
                byte[] finaling = baos.toByteArray();
                final StorageReference filePath;
                filePath = storageReference.child("Notice").child(finaling+"jpg");
                final UploadTask uploadTask = filePath.putBytes(finaling);
                uploadTask.addOnCompleteListener(uploadnotice.this, new OnCompleteListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<UploadTask.TaskSnapshot> task) {

                        if (task.isSuccessful()){

                            uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                    filePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                        @Override
                                        public void onSuccess(Uri uri) {

                                            downloadUrl = String.valueOf(uri);
                                            uploadData();
                                        }
                                    });
                                }
                            });

                        }else {
                            pd.dismiss();
                            Toast.makeText(uploadnotice.this,"something wenty wrong",Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }

            private void uploadData() {

                reference = reference.child("Notice");
                final String uniqueKey = reference.push().getKey();

                String title = noticeTitle.getText().toString();

                Calendar calForDate = Calendar.getInstance();
                SimpleDateFormat currentDate = new SimpleDateFormat("dd-MM-yy");
                String date = currentDate.format(calForDate.getTime());

                Calendar calForTime = Calendar.getInstance();
                SimpleDateFormat currentTime = new SimpleDateFormat("hh:mm a");
                String time = currentTime.format(calForTime.getTime());

                NoticeData noticeData = new NoticeData(title,downloadUrl,date,time,uniqueKey);
                reference.child(uniqueKey).setValue(noticeData).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        pd.dismiss();

                        Toast.makeText(uploadnotice.this,"Notice Uploaded",Toast.LENGTH_SHORT).show();


                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull @NotNull Exception e) {
                        pd.dismiss();

                        Toast.makeText(uploadnotice.this,"Something went wrong",Toast.LENGTH_SHORT).show();

                    }
                });

            }

        });






        noticeImageView = findViewById(R.id.noticeImageView);

        addImage = findViewById(R.id.addimage);



        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });
    }

    private void openGallery() {
        Intent pickImage = new Intent(Intent .ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickImage,REQ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ && resultCode == RESULT_OK) {

            Uri uri = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
            } catch (IOException e) {
                e.printStackTrace();
            }

            noticeImageView.setImageBitmap(bitmap);
        }
    }
}