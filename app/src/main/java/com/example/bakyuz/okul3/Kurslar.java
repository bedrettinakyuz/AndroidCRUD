package com.example.bakyuz.okul3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Kurslar extends AppCompatActivity {
    TextView text1;
    ListView KursListesi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kurslar);
        final String Kurslar [] = {"Bilişim","İngilizce","Resim","Müzik","Kaligrafi"};
        text1 = findViewById(R.id.textView);
         KursListesi=(ListView) findViewById(R.id.ListViewKurs);
        ArrayAdapter<String> veriAdaptoru=new ArrayAdapter<String>
        (this, android.R.layout.simple_list_item_1, android.R.id.text1, Kurslar);
        KursListesi.setAdapter(veriAdaptoru);
    }
}
