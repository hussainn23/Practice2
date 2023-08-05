package com.example.practice3;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.practice3.databinding.LoginBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;


public class LoginC extends AppCompatActivity {
    private LoginBinding binding;

    SharedPrefManager sharedPrefManager;

    FirebaseFirestore firestore;

    Utils utils;//

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = LoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPrefManager= new SharedPrefManager(LoginC.this);
            firestore= FirebaseFirestore.getInstance();
        utils=new Utils(LoginC.this);


        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!empty())
                {

                    save();

                    /*SharedPreferences.Editor editor;
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(LoginC.this);
                    editor= preferences.edit();*/

                    //editor.putString("token","1234");
                    //editor.apply();

                    /*utils.putToken("Token");

                    Toast.makeText(LoginC.this, "Login successful", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(LoginC.this, MainActivity.class));*/



                }
                else {
                    Toast.makeText(LoginC.this, "Provide complete data", Toast.LENGTH_LONG).show();



                }

            }
        });
        binding.etSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LoginC.this, MainActivity.class));
            }
        });

        get();
    }
    public void get(){




        List<ModelUser> usersList = null;

        firestore.collection("User").whereEqualTo("userName",binding.etEmail.getText())
                .whereEqualTo("lastMsg",binding.etPassword.getText())
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if(task.isSuccessful()){



                          /*  if(task.getResult().size() >0){

                                Toast.makeText(LoginC.this, "", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                firestore.collection("User").add(modelUser);
                            }*/

                            ModelUser modelUser=null;

                            for (QueryDocumentSnapshot document : task.getResult()) {

                                modelUser= document.toObject(ModelUser.class);
                                modelUser.setDocId(document.getId());

                            }

                            sharedPrefManager.putUser(modelUser);
                            sharedPrefManager.putToken(modelUser.getDocId().toString());
                            // new Activity Start
                            // fininsh

                        }



                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {



                    }
                });

    }

    public void save(){

        ModelUser modelUser= new ModelUser(binding.etEmail.getText().toString(), binding.etPassword.getText().toString()  );




        //firestore.collection("User").add(modelUser);



        /*firestore.collection("User").add(modelUser)
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        Toast.makeText(LoginC.this, "Data saved", Toast.LENGTH_SHORT).show();
                    }
                });*/




        firestore.collection("User").add(modelUser)
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {

                        Toast.makeText(LoginC.this, "Data saved", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {


                        Toast.makeText(LoginC.this, "Something went wrong", Toast.LENGTH_SHORT).show();


                    }
                });
    }
    public boolean empty()
    {
        boolean empty=false;
        String useremail;
        String Password;

        useremail=binding.etEmail.getText().toString();
        Password=binding.etPassword.getText().toString();
        if(useremail.isEmpty()) empty=true;
        else if(Password.isEmpty()) empty=true;
        return empty;
    }
    public void animation()
    {
        Dialog dialog=new Dialog(this);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.loading_animation);
        dialog.show();
    }
}