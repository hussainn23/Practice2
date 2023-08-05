package com.example.practice3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    Utils utils;
    Context context;


    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=MainActivity.this;


        utils= new Utils(context);
        recyclerView= findViewById(R.id.rvUser);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));





        SharedPrefManager sharedPrefManager= new SharedPrefManager(MainActivity.this);


        ModelUser modelUser= sharedPrefManager.getUser();


        setData();

    }


    public void setData(){

        List<ModelUser> modelUsersList = new ArrayList<>();//= new ModelUser();



        ModelUser tempModelUser= new ModelUser("XYZ","LastMsg");
        ModelUser tempModelUser2= new ModelUser("ABC","LastMsg");
        ModelUser tempModelUser3= new ModelUser("GHJ","LastMsg");
        ModelUser tempModelUser4= new ModelUser("IOP","LastMsg");
        ModelUser tempModelUser5= new ModelUser("IOP","LastMsg");
        ModelUser tempModelUser6= new ModelUser("IOP","LastMsg");
        ModelUser tempModelUser7= new ModelUser("IOP","LastMsg");
        ModelUser tempModelUser8= new ModelUser("IOP","LastMsg");
        ModelUser tempModelUser9= new ModelUser("IOP","LastMsg");

        modelUsersList.add(tempModelUser);
        modelUsersList.add(tempModelUser2);
        modelUsersList.add(tempModelUser3);
        modelUsersList.add(tempModelUser4);
        modelUsersList.add(tempModelUser5);
        modelUsersList.add(tempModelUser6);
        modelUsersList.add(tempModelUser7);
        modelUsersList.add(tempModelUser8);
        modelUsersList.add(tempModelUser9);

        AdapterUser adapterUser= new AdapterUser(context,modelUsersList);
        recyclerView.setAdapter(adapterUser);



    }
}