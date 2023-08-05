package com.example.practice3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ActivityUserApi extends AppCompatActivity {


        private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;

    private String url = "http://www.mocky.io/v2/597c41390f0000d002f4dbd1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_api);

    }


    private void sendAndRequestResponse() {

        //RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(this);
        //String Request initialized
        mStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {


                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray usersArry= jsonObject.getJSONArray("users");
                    for(int i = 0; i < usersArry.length(); i++){

                        JSONObject user= usersArry.getJSONObject(i);

                        String userName = user.getString("name");
                        Toast.makeText(ActivityUserApi.this, userName, Toast.LENGTH_SHORT).show();

                        JSONObject userContacts= user.getJSONObject("contact");

                        String userContactMobile= userContacts.getString("mobile");
                        Toast.makeText(ActivityUserApi.this, userContactMobile, Toast.LENGTH_SHORT).show();


                    }


                }       catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                //Toast.makeText(getApplicationContext(),"Response :" + response.toString(), Toast.LENGTH_LONG).show();//display the response on screen

            }
        }


        mRequestQueue.add(mStringRequest);
    }
}