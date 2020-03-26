package com.example.cuzdanimheabim.activtiy;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cuzdanimheabim.R;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    Button btnYeniKullanici ,btnGiris;
    ImageView imgLogo;
    TextView txtLogoName,txtSlogan;
    TextInputLayout kullaniciAdi,Sifre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_login);

        init();
        events();
    }

    private void init() {
        try {
            btnYeniKullanici = findViewById(R.id.btnYeniKullanici);
            btnGiris = findViewById(R.id.btnGiris);
            imgLogo = findViewById(R.id.imgLoginLogo);
            txtLogoName = findViewById(R.id.txtLogoName);
            txtSlogan = findViewById(R.id.textView);
            kullaniciAdi = findViewById(R.id.textInputLayout);
            Sifre = findViewById(R.id.textInputLayout2);

        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void events() {
        try {
            btnYeniKullanici.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    YeniKullaniciKayitEkraninaGit();
                }
            });
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void YeniKullaniciKayitEkraninaGit() {
        try {
            Intent yeniKullaniciKayitEkraniIntent = new Intent(LoginActivity.this, SignUpActivity.class);
            Pair[] pairs = new Pair[7];
            pairs[0] = new Pair<View, String>(imgLogo, "logo_image");
            pairs[1] = new Pair<View, String>(txtLogoName, "logo_text");
            pairs[2] = new Pair<View, String>(txtSlogan, "logo_desc");
            pairs[3] = new Pair<View, String>(kullaniciAdi, "username_tran");
            pairs[4] = new Pair<View, String>(Sifre, "password_tran");
            pairs[5] = new Pair<View, String>(btnGiris, "button_tran");
            pairs[6] = new Pair<View, String>(btnYeniKullanici, "login_signup_tran");

            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, pairs);
            startActivity(yeniKullaniciKayitEkraniIntent, activityOptions.toBundle());

        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
