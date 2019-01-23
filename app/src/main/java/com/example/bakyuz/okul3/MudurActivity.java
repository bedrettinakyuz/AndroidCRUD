package com.example.bakyuz.okul3;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MudurActivity extends AppCompatActivity {
    EditText txt_ogrAd;
    EditText txt_ogrSoyad;
    EditText txt_ogrNumara;
    Button btn_Kaydet;
    Button btn_Listele;
    Button btn_Sil;
    Button btn_Guncelle;

    Ogrenci ogr;
    Adapter adapter;
    Database db;
    ListView listView_OGrenci;
    List<Ogrenci> ogrenciList = new ArrayList<Ogrenci>();
    int itemId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mudur);


        //TXT LER
        txt_ogrAd=findViewById(R.id.txtAd);
        txt_ogrSoyad=findViewById(R.id.txtSoyad);
        txt_ogrNumara=findViewById(R.id.txtOkulNo);
        //BUTTON LAR
        btn_Kaydet=findViewById(R.id.btnEkle);
        btn_Listele=findViewById(R.id.btnListele);
        btn_Sil=findViewById(R.id.btnSil);
        btn_Guncelle=findViewById(R.id.btnGuncelle);


        db = new Database(getApplicationContext());
        listView_OGrenci = findViewById(R.id.listView1);

        //K A Y D E T     C L I C K
        btn_Kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ogrAd= txt_ogrAd.getText().toString();
                String ogrSoyad=txt_ogrSoyad.getText().toString();
                String ogrNumara=txt_ogrNumara.getText().toString();
                if(ogrAd.isEmpty()|| ogrSoyad.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Alanları Boş Bırakamazsınız",Toast.LENGTH_LONG).show();
                    return;
                }
                else{
                    Ogrenci ogrenci = new Ogrenci();
                    ogrenci.setOgrAd(ogrAd);
                    ogrenci.setOgrSoyad(ogrSoyad);
                    ogrenci.setOgrNumara(ogrNumara);
                    Database db = new Database(getApplicationContext());
                    long kayitKontrol=db.ogrEkle(ogrenci);
                    if(kayitKontrol >=0 )
                        Toast.makeText(getApplicationContext(),"Kayıt Başarılı",Toast.LENGTH_LONG).show();
                }
                Listele();
            }
        });
        //L İ S T E L E     C L I C K
        btn_Listele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Listele();
            }
        });
        //LİSTVİEW CLICK
        listView_OGrenci.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ogr = (Ogrenci)adapter.getItem(position);

                txt_ogrAd.setText(ogr.getOgrAd());
                txt_ogrSoyad.setText(ogr.getOgrSoyad());
                txt_ogrNumara.setText(ogr.getOgrNumara());
            }
        });

        //S İ L C L İ C K
        btn_Sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               db.ogrenciSil(ogr);
                Listele();

            }
        });


    //  G U N C E L L E C L I CK
        btn_Guncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               ogr.setOgrNumara(txt_ogrNumara.getText().toString());
               ogr.setOgrAd(txt_ogrAd.getText().toString());
               ogr.setOgrSoyad(txt_ogrSoyad.getText().toString());




                db.ogrenciGuncelle(ogr);
                Listele();
            }
        });



    }

    public void Listele() {
        ogrenciList =db.ogrListele();
        adapter = new Adapter(MudurActivity.this,ogrenciList);
        listView_OGrenci.setAdapter(adapter);




    }
}
