package com.example.practice3;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

public class SharedPrefManager {

    SharedPreferences sharedPreferences;    // = PreferenceManager.getDefaultSharedPreferences(sharedPreference.this);
    SharedPreferences.Editor editor;     // = sharedPreferences.edit();


    public void putUser(ModelUser modelUser){

        /*Gson gson = new Gson();
        String json = gson.toJson(modelUser);
        editor.putString("User", json);*/


        editor.putString("User" , new Gson().toJson(modelUser));

    }

    public ModelUser getUser(){


        /*String json = sharedPreferences.getString("User", "");
        Gson gson = new Gson();
        ModelUser modelUser = gson.fromJson(json, ModelUser.class);
        return modelUser;*/

        return new Gson().fromJson(sharedPreferences.getString("User", ""),ModelUser.class);

    }

        public SharedPrefManager(Context context){



        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }


    public void putToken(String token){
        editor.putString("token",token).apply();
    }


    public String getToken(){
        return sharedPreferences.getString("token", "");
    }

    public boolean isLoggedIn(){

        if (getToken().isEmpty()|| getToken()==null) return false;
        else return true;
    }

}
