package com.example.bakyuz.okul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ogretmen extends AppCompatActivity {
    Button btnMesaj;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogretmen);
        i = getIntent();
        String s = i.getStringExtra("mesaj");
        TextView tv_Giris =(TextView)findViewById(R.id.tvGiris);
        btnMesaj=findViewById(R.id.btnOgrMesaj);
        tv_Giris.setText(("Hoşgeldiniz Ogretmen " + s +" Bey"));
        btnMesaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i = new Intent(Ogretmen.this,Mesaj.class);
                startActivity(i);
            }
        });
    }
}
