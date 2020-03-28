package com.example.cuzdanimheabim.activtiy;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.cuzdanimheabim.R;
import com.example.cuzdanimheabim.adapter.SliderAdapter;

public class OnBoardActivity extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout lnrDots;
    SliderAdapter sliderAdapter;
    TextView[] dots;
    Button btnStart;
    Animation animation;
    int currentPosition;

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            currentPosition = position;
            if (position == 0) {
                btnStart.setVisibility(View.INVISIBLE);
            } else if (position == 1) {
                btnStart.setVisibility(View.INVISIBLE);
            } else if (position == 2) {
                btnStart.setVisibility(View.INVISIBLE);
            } else {
                animation = AnimationUtils.loadAnimation(OnBoardActivity.this, R.anim.bottom_animation);
                btnStart.setAnimation(animation);
                btnStart.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_board);
        init();
    }

    private void init() {
        try {

            viewPager = findViewById(R.id.onBoardPager);
            lnrDots = findViewById(R.id.lnrDots);
            btnStart = findViewById(R.id.btnStart);

            sliderAdapter = new SliderAdapter(this);
            viewPager.setAdapter(sliderAdapter);

            addDots(0);
            viewPager.addOnPageChangeListener(changeListener);

        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void addDots(int position) {
        try {
            dots = new TextView[4];
            lnrDots.removeAllViews();

            for (int i = 0; i < dots.length; i++) {
                dots[i] = new TextView(this);
                dots[i].setText(Html.fromHtml("&#8226"));
                dots[i].setTextSize(35);
                lnrDots.addView(dots[i]);
            }

            if (dots.length > 0) {
                dots[position].setTextColor(getResources().getColor(R.color.colorAccent));
            }

        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void skip(View view) {
        try {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void next(View view) {
        try {
            viewPager.setCurrentItem(currentPosition + 1);
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
