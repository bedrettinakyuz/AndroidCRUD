package com.example.bakyuz.okul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VeliGiris extends AppCompatActivity {
    Intent i;
    Button ogrHarita;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veli_giris);

        i = getIntent();
        String s = i.getStringExtra("mesaj");
        TextView tv_Giris =(TextView)findViewById(R.id.tvGiris);
        tv_Giris.setText(("Hoşgeldiniz Sn" + s));
        ogrHarita=findViewById(R.id.btnOgrenciHarita);
        ogrHarita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(VeliGiris.this,OgrenciHarita.class);
                startActivity(i);
            }
        });
    }
}
