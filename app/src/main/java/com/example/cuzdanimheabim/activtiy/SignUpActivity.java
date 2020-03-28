package com.example.cuzdanimheabim.activtiy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cuzdanimheabim.R;
import com.google.android.material.textfield.TextInputLayout;

public class SignUpActivity extends AppCompatActivity {

    TextInputLayout edtAdSoyad, edtKullaniciAdi, edtEmail, edtSifre;
    Button btnKayitOl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        init();
        events();
    }


    private void init() {
        try {
            edtAdSoyad = findViewById(R.id.edtAdSoyad);
            edtKullaniciAdi = findViewById(R.id.edtKullaniciAdi);
            edtEmail = findViewById(R.id.edtEmail);
            edtSifre = findViewById(R.id.edtSifre);
            btnKayitOl = findViewById(R.id.btnKayitOl);
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void events() {
        try {
            btnKayitOl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    kayitOl();
                }
            });
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void kayitOl() {
        try {
            if (!adSoyadKontrol() | !kullaniciAdiKontrol() | !eMailKontrol() | !sifreKontrol()) {
                return;
            }
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    private Boolean adSoyadKontrol() {
        if (edtAdSoyad.getEditText().length() == 0) {
            edtAdSoyad.setError("Boş Bırakılamaz!");
            return false;
        } else {
            edtAdSoyad.setError(null);
            return true;
        }
    }

    private Boolean kullaniciAdiKontrol() {
        if (edtKullaniciAdi.getEditText().length() == 0) {
            edtKullaniciAdi.setError("Boş Bırakılamaz!");
            return false;
        } else if (edtKullaniciAdi.getEditText().length() >= 15) {
            edtKullaniciAdi.setError("Kullanıcı Adı Çok Uzun!");
            return false;
        } else {
            edtKullaniciAdi.setError(null);
            return true;
        }
    }

    private Boolean eMailKontrol() {
        if (edtEmail.getEditText().length() == 0) {
            edtEmail.setError("Boş Bırakılamaz!");
            return false;
        } else {
            edtEmail.setError(null);
            return true;
        }
    }

    private Boolean sifreKontrol() {
        if (edtSifre.getEditText().length() == 0) {
            edtSifre.setError("Boş Bırakılamaz!");
            return false;
        } else if (edtSifre.getEditText().length() <= 9) {
            edtSifre.setError("Şifre Daha Güçlü Olmalıdır!");
            return false;
        } else {
            edtSifre.setError(null);
            return true;
        }
    }
}
