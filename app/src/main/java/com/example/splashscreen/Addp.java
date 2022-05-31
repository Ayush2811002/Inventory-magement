package com.example.splashscreen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.InputStream;

public class Addp extends AppCompatActivity {
    private ImageView img3;
    private Button button4,button5;
    private Uri filepath;
    private Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addp);
        img3=findViewById(R.id.img3);
        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
button4.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Dexter.withActivity(Addp.this)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                 .withListener(new PermissionListener() {
                     @Override
                     public void onPermissionGranted(PermissionGrantedResponse response)
                     {
                         Intent intent = new Intent(Intent.ACTION_PICK);
                         intent.setType("image/*");
                         startActivityForResult (Intent.createChooser(intent,"Please insert image"),2);



                     }

                     @Override
                     public void onPermissionDenied(PermissionDeniedResponse response) {

                     }

                     @Override
                     public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                       token.continuePermissionRequest();
                     }
                 }).check();
    }
});
button5.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        uploadtoFirbase();
    }
});

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==2&&requestCode==RESULT_OK){


            filepath=data.getData();
            try {
                InputStream inputStream= getContentResolver().openInputStream(filepath);
                bitmap= BitmapFactory.decodeStream(inputStream);
                img3.setImageBitmap(bitmap);

            }catch (Exception ex){

            }
        }

        super.onActivityResult(requestCode, resultCode, data);

    }




    private void uploadtoFirbase() {

        ProgressDialog dialog=new ProgressDialog(this);
        dialog.setTitle("File Uploader");
        dialog.show();
        FirebaseStorage storage=FirebaseStorage.getInstance();
        StorageReference   uploder=storage.getReference().child("image1");
        uploder.putFile(filepath)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(), "File uploaded", Toast.LENGTH_SHORT).show();

                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                        float percent=(100*snapshot.getBytesTransferred())/snapshot.getTotalByteCount();
                        dialog.setMessage("Uploded :"+(int)percent+"%");



                    }
                });





    }

}
