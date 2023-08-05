//package com.example.practice3;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.app.Dialog;
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Color;
//import android.graphics.drawable.ColorDrawable;
//import android.os.Bundle;
//import android.os.Handler;
//import android.view.View;
//import android.view.Window;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.example.practice3.databinding.ActivityMainBinding;
//
//public class MainActivity extends AppCompatActivity {
//    private ActivityMainBinding binding;
//    private Context context;
//    private static final String FACEBOOK_PROFILE_URL = "https://www.facebook.com/profile.php?id=100089085785909&mibextid=ZbWKwL";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        context = MainActivity.this;
//
//        binding.btnJoinNow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                String name = binding.etUserName.getText().toString();
////                Intent intent = new Intent(context, SignupPractice.class);
//                intent.putExtra("name", name);
//                startActivity(intent);
//            }
//        });
//    }
//
//    public boolean isEmpty() {
//        String username = binding.etUserName.getText().toString();
//        String lastname = binding.etLuserName.getText().toString();
//        String useremail = binding.etUserEmail.getText().toString();
//        String password = binding.etUserPassword.getText().toString();
//
//        return username.isEmpty() || lastname.isEmpty() || useremail.isEmpty() || password.isEmpty();
//    }
//
//    public void showDialog() {
//        Dialog dialog = new Dialog(context);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        dialog.setCancelable(false);
//        dialog.setContentView(R.layout.test);
//        dialog.show();
//
//        Handler handler = new Handler();
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                dialog.cancel();
//                openFacebookProfile();
//            }
//        };
//        handler.postDelayed(runnable, 3000);
//    }
//
//    private void openFacebookProfile() {
//        // Code to open Facebook profile goes here
//        // Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(FACEBOOK_PROFILE_URL));
//        // startActivity(intent);
//    }
//}
