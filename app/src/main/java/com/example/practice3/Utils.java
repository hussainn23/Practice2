package com.example.practice3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Utils {




    SharedPreferences.Editor editor;
    SharedPreferences preferences ;

    Context iContext;



    //SQLite

    public Utils(Context oContext){

        this.iContext=oContext;
        preferences = PreferenceManager.getDefaultSharedPreferences(iContext);
        editor=preferences.edit();

    }


    public void putToken(String token){

        editor.putString("token",token).apply();

    }


    public String getToken(){

        String token = preferences.getString("token", "");
        return token;

    }



    public void logout(){
        putToken("");
    }
    public boolean IsLoggedIn(){
        boolean loggedIn= true;
        if(getToken().isEmpty()) loggedIn=false;
        return loggedIn;

    }


}
