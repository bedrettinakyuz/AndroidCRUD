package com.example.bakyuz.okul3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.util.Date;

public class OgrenciHarita extends AppCompatActivity {
    EditText txt_tarih;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogrenci_harita);
        txt_tarih=findViewById(R.id.txtTarih);
        Date tarih = new Date();
        txt_tarih.setText(tarih.toString());

    }
}
