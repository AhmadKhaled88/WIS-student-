package com.example.admin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
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

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class the_major extends AppCompatActivity {
    private CardView addPdf ;
    private final int REQ = 1 ;
    private Uri pdfData ;
    private EditText pdfTitle  ;
    private String title;
    private String pdfName;
    private Button uploadPdfBtn  ;
    private TextView pdfTextView;
    private DatabaseReference databaseReference ;
    private StorageReference storageReference;

    private ProgressDialog pd ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_major);

        this.setTitle("ADD PDF");

        databaseReference = FirebaseDatabase.getInstance().getReference();
        storageReference = FirebaseStorage.getInstance().getReference();
        pd = new ProgressDialog(this);
        pdfTextView=findViewById(R.id.pdfTextView);
        addPdf = findViewById(R.id.addpdf);
        pdfTitle=findViewById(R.id.pdfTitle);

        uploadPdfBtn = findViewById(R.id.uploadPDF);

        addPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDownload();
            }
        });

        uploadPdfBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             title = pdfTitle.getText().toString();
             if (title.isEmpty()){
                 pdfTitle.setError("Empty");
                 pdfTitle.requestFocus();

             }else  if(pdfTitle ==null){
                 Toast.makeText(the_major.this,"Please upload pdf",Toast.LENGTH_SHORT).show();

             }else {

                 uploadPdf();
             }

            }
        });
    }

    private void uploadPdf() {
        pd.setTitle("Please wait...");
        pd.setMessage("Uploading pdf");
        pd.show();
        StorageReference reference = storageReference.child("pdf/"+pdfName+"-"+System.currentTimeMillis()+".pdf");
        reference.putFile(pdfData).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri>uriTask= taskSnapshot.getStorage().getDownloadUrl();
                while (!uriTask.isComplete());
                Uri uri = uriTask.getResult();
                uploadData(String.valueOf(uri));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull  Exception e) {
                pd.dismiss();
                Toast.makeText(the_major.this,"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void uploadData(String downloadUrl) {
        String uniqueKey=databaseReference.child("pdf").push().getKey();
        HashMap data = new HashMap();
        data.put("pdfTitle",title);
        data.put("pdfUrl",downloadUrl);


        databaseReference.child("pdf").child(uniqueKey).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<Void> task) {
                pd.dismiss();
                Toast.makeText(the_major.this,"pdf uploaded successfully ",Toast.LENGTH_SHORT).show();
                pdfTitle.setText("");

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull @NotNull Exception e) {
                pd.dismiss();
                Toast.makeText(the_major.this,"Failed to upload pdf",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openDownload() {
        Intent intent= new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Pdf File"),REQ);
    }

    @SuppressLint("Range")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ && resultCode == RESULT_OK) {

            pdfData = data.getData();

           if(pdfData.toString().startsWith("content://")){
               Cursor cursor = null;
               try {
                   cursor= the_major.this.getContentResolver().query(pdfData,null,null,null,null);
                   if (cursor != null && cursor.moveToFirst()){
                       pdfName=cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                   }
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }else if(pdfData.toString().startsWith("file://")){
             pdfName = new File(pdfData.toString()).getName();
           }
           pdfTextView.setText(pdfName);


        }
    }
}
