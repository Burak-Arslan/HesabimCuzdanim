package com.example.cuzdanimheabim.activtiy;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cuzdanimheabim.R;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 3000;

    Animation topAnimation, bottomAnimation;
    ImageView imgSplash;
    TextView txtOnSoz, txtCuzdanimHesabim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_main);

        init();
        initAnimation();
        initHandlerIntent();
    }

    private void init() {
        try {
            topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
            bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

            txtCuzdanimHesabim = findViewById(R.id.txtCuzdanimHesabim);
            txtOnSoz = findViewById(R.id.txtOnSoz);
            imgSplash = findViewById(R.id.imgSplash);
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void initAnimation() {
        try {
            imgSplash.setAnimation(topAnimation);
            txtOnSoz.setAnimation(bottomAnimation);
            txtCuzdanimHesabim.setAnimation(bottomAnimation);
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void initHandlerIntent() {
        try {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                    Pair[] pairs = new Pair[2];

                    pairs[0] = new Pair<View, String>(imgSplash, "logo_image");
                    pairs[1] = new Pair<View, String>(imgSplash, "logo_text");

                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                    startActivity(loginIntent, activityOptions.toBundle());

                }
            }, SPLASH_SCREEN);
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
