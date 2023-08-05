package com.example.practice3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ActivityUserProfile extends AppCompatActivity {

    ImageView imgUserProfile;
    int SELECT_PICTURE = 200;

    FirebaseFirestore firestore;

    Uri imageUri=null;
    //StorageReference storageRef ;//= storage.getReference();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Button  btnUploadImage= findViewById(R.id.btnUploadImage);
        Button  btnGetImage= findViewById(R.id.btnGetImage);
         imgUserProfile= findViewById(R.id.imgUserProfile);
        firestore= FirebaseFirestore.getInstance();

         //storageRef = FirebaseStorage.getInstance().getReference();


        btnGetImage.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View v) {
                        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                        photoPickerIntent.setType("image/*");
                        startActivityForResult(photoPickerIntent, SELECT_PICTURE);
                    }
        });
        btnUploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(imageUri!=null) uploadImage();
                else Toast.makeText(ActivityUserProfile.this, "Please Select Image", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            try {
                imageUri = data.getData();

                Glide.with(this).load(imageUri).into(imgUserProfile);

                /*final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                imgUserProfile.setImageBitmap(selectedImage);*/




            } catch (Exception e) {
                e.printStackTrace();
            }

        }else {
            Toast.makeText(ActivityUserProfile.this, "You haven't picked Image",Toast.LENGTH_LONG).show();
        }

    }


    void uploadImage(){

        //imageUri

        final StorageReference fileRef
                = FirebaseStorage.getInstance().getReference(System.currentTimeMillis()+imageUri.toString() );


        fileRef.putFile(imageUri)
                .addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {

                        //Toast.makeText(ActivityUserProfile.this, "Image Uploaded", Toast.LENGTH_SHORT).show();

x
                        fileRef.getDownloadUrl()
                                .addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {

                                        String url= uri.toString();


                                        SharedPrefManager sharedPrefManager = new SharedPrefManager(ActivityUserProfile.this);


                                        ModelUser tempUser= sharedPrefManager.getUser();
                                        tempUser.setProfile(url);



                                        firestore.collection("User").document(tempUser.docId)
                                                .set(tempUser)
                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {


                                                        sharedPrefManager.putUser(tempUser);

                                                    }
                                                });





                                    }
                                });




                    }
                });



    }


}