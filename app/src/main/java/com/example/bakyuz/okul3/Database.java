package com.example.bakyuz.okul3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.*;


public class Database extends SQLiteOpenHelper {
    String satir;
    private static final String veriTabaniAdi ="dbOgrenci";
    private static final String tabloAdi ="ogrTablo";
    private static  final int veritabaniVersiyon=1;
    private static  final String CREATE_TABLE ="CREATE TABLE "+ tabloAdi +"(ID INTEGER PRIMARY KEY AUTOINCREMENT, AD TEXT, SOYAD TEXT, NUMARA TEXT)";

    public Database(Context context) {

        super(context,veriTabaniAdi,null,veritabaniVersiyon);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ tabloAdi);
    }
    public Long ogrEkle(Ogrenci ogrenci){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("AD",ogrenci.getOgrAd());
        cv.put("SOYAD",ogrenci.getOgrSoyad());
        cv.put("NUMARA",ogrenci.getOgrNumara());
        long result = db.insert(tabloAdi,null,cv);
        return result;//kayıt eklendiyese true döndür
    }

    //OGRENCİ LİSTELE
    public List<Ogrenci> ogrListele(){

        List<Ogrenci> ogrenciListesi = new ArrayList<Ogrenci>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sqlSorgusu ="Select* from "+ tabloAdi;
        Cursor cr = db.rawQuery(sqlSorgusu,null);
        int siraNoId= cr.getColumnIndex("ID");
        int siraNoAd= cr.getColumnIndex("AD");
        int siraNoSoyad= cr.getColumnIndex("SOYAD");
        int siraNoNumara= cr.getColumnIndex("NUMARA");
        try{
            while(cr.moveToNext()){
                Ogrenci _ogrenci = new Ogrenci();
                _ogrenci.setOgrId(cr.getInt(siraNoId));
                _ogrenci.setOgrAd(cr.getString(siraNoAd));
                _ogrenci.setOgrSoyad(cr.getString(siraNoSoyad));
                _ogrenci.setOgrNumara(cr.getString(siraNoNumara));


                ogrenciListesi.add(_ogrenci);
            }

        }
        finally {
            cr.close();
            db.close();
        }

        return ogrenciListesi;



    }

    //öğrenci silme
    public void ogrenciSil(Ogrenci ogr)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        int id = ogr.getOgrId();

        db.delete(tabloAdi,"ID="+id,null);
        db.close();

    }
    public void ogrenciGuncelle(Ogrenci ogr){
        SQLiteDatabase db = this.getWritableDatabase();
        int id = ogr.getOgrId();
        ContentValues cv = new ContentValues();
        cv.put("AD",ogr.getOgrAd());
        cv.put("SOYAD",ogr.getOgrSoyad());
        cv.put("NUMARA",ogr.getOgrNumara());
        db.update(tabloAdi,cv,"ID="+id,null);
        db.close();





    }




}
