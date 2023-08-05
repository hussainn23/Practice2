package com.example.practice3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity  extends AppCompatActivity {

    Context context;
    Utils utils;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler handler=new Handler();
        context= SplashActivity.this;
        utils= new Utils(context);

       Runnable runnable=new Runnable() {
           @Override
           public void run() {



               if(utils.IsLoggedIn()) startActivity(new Intent(context, MainActivity.class));
               else startActivity(new Intent(SplashActivity.this, LoginC.class));

               finish();

           }





       };
       handler.postDelayed(runnable,3000);
    }
}
