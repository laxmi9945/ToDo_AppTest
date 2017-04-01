package com.app.todo.ui;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.app.todo.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final ImageView imageView=(ImageView)findViewById(R.id.splashimage);
        Animation animation= AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate);
        final Animation anim= AnimationUtils.loadAnimation(getBaseContext(),R.anim.abc_fade_out);
        imageView.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.startAnimation(anim);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                        finish();
                    }
                },3000);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
}
