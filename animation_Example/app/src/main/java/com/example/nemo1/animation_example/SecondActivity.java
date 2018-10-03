package com.example.nemo1.animation_example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {
    private ImageView imageView;
    private Animation animation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivity_second);
    }

    @Override
    protected void onStart() {
        super.onStart();
        imageView = findViewById(R.id.second_img);
        animation = AnimationUtils.loadAnimation(this,R.anim.zoom_anim);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(animation);
                animation.setDuration(2000);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
