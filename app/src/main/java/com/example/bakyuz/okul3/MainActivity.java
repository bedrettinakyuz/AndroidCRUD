package com.example.bakyuz.okul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup radio_Grubu;
    RadioButton rb_Mudur;
    RadioButton rb_Ogretmen;
    RadioButton rb_Veli;
    RadioButton rb_Ogrenci;
    RadioButton rb_Hizmetli;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edt_KAdi =(EditText)findViewById(R.id.edtKAdi);
        final EditText edt_Sifre =(EditText)findViewById(R.id.edtSifre);
        rb_Mudur=(RadioButton)findViewById(R.id.radioMudur);
        rb_Mudur=(RadioButton)findViewById(R.id.radioOgretmen);
        rb_Mudur=(RadioButton)findViewById(R.id.radioVeli);
        rb_Mudur=(RadioButton)findViewById(R.id.radioOgrenci);
        rb_Mudur=(RadioButton)findViewById(R.id.radioHizmetli);
        radio_Grubu=(RadioGroup)findViewById(R.id.radioGrubu);

        ((Button)findViewById(R.id.btnGiris)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int seciliRadio = radio_Grubu.getCheckedRadioButtonId();
                switch(seciliRadio)
                {
                    case R.id.radioMudur:
                    {
                       i = new Intent(MainActivity.this,MudurGiris.class);
                        break;
                    }
                    case R.id.radioOgretmen:
                    {
                        i = new Intent(MainActivity.this,Ogretmen.class);

                        break;
                    }
                    case R.id.radioVeli:
                    {
                        i = new Intent(MainActivity.this,VeliGiris.class);
                        break;
                    }
                    case R.id.radioOgrenci:
                    {

                        i = new Intent(MainActivity.this,OgrenciGiris.class);
                        break;
                    }
                    case R.id.radioHizmetli:
                    {
                        i = new Intent(MainActivity.this,HizmetliGiris.class);
                        break;
                    }

                }
                i.putExtra("mesaj",edt_KAdi.getText().toString());
                startActivity(i);
            }
        });
    }
}
