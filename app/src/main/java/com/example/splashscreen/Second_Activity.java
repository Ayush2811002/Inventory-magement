package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class Second_Activity extends AppCompatActivity {
    private  static int Splash_timeout= Integer.parseInt("3000");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splash=new Intent(Second_Activity.this,Third.class);
                startActivity(splash);
                finish();
            }
        },Splash_timeout);
        Animation myani= AnimationUtils.loadAnimation(Second_Activity.this,R.anim.animtion2);
    }
}