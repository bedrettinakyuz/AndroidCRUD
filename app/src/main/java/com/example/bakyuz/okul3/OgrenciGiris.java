package com.example.bakyuz.okul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OgrenciGiris extends AppCompatActivity {
    Intent i;
    Button btnMesaj,btnKursIslemleri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogrenci_giris);
        i = getIntent();
        String s = i.getStringExtra("mesaj");
        TextView tv_Giris =(TextView)findViewById(R.id.tvGiris);
        btnKursIslemleri=findViewById(R.id.btnKursIslemleri);
        tv_Giris.setText(("Hoşgeldin "+s));
        btnMesaj = findViewById(R.id.btnOMesaj);
        btnMesaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(OgrenciGiris.this,Mesaj.class);
                startActivity(i);
            }
        });
        btnKursIslemleri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(OgrenciGiris.this,Kurslar.class);
                startActivity(i);

            }
        });
    }
}
