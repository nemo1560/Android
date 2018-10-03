package com.example.nemo1.animation_example;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView logo_img;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        logo_img = findViewById(R.id.logo_img);
        animation = AnimationUtils.loadAnimation(this,R.anim.logo_fadein_anim);
        logo_img.startAnimation(animation);
        final Intent intent = new Intent(this,SecondActivity.class);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                overridePendingTransition(R.anim.logo_fadein_anim,R.anim.logo_fadeout_anim);
            }
        },3000);
    }
}
