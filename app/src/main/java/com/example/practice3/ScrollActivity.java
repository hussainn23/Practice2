package com.example.practice3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.practice3.databinding.ScrollViewBinding;

public class ScrollActivity extends AppCompatActivity {
    private ScrollViewBinding binding;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ScrollViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
