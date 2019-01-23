package com.example.bakyuz.okul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HizmetliGiris extends AppCompatActivity {
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hizmetli_giris);
        i = getIntent();
        String s = i.getStringExtra("mesaj");
        TextView tv_Giris =(TextView)findViewById(R.id.tvGiris);
        tv_Giris.setText(("Hoşgeldiniz Görevli"+s));
    }
}
