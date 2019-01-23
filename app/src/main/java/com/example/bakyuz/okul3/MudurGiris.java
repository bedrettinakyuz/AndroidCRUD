package com.example.bakyuz.okul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MudurGiris extends AppCompatActivity {
    Button ogr_Ekle;
    Button btn_Mesaj;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mudur_giris);
        ogr_Ekle=(Button)findViewById(R.id.btnOgrEkle);
        btn_Mesaj=(Button)findViewById(R.id.btnMMesaj);
        ogr_Ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 i = new Intent(MudurGiris.this,MudurActivity.class);
                startActivity(i);
            }
        });

        i = getIntent();
        String s = i.getStringExtra("mesaj");
        TextView tv_Giris =(TextView)findViewById(R.id.tvGiris);
        tv_Giris.setText(("Hoşgeldiniz Müdür " + s +" Bey"));

        btn_Mesaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(MudurGiris.this,Mesaj.class);
                startActivity(i);
            }
        });
    }
}
