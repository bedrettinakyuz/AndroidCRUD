package com.example.bakyuz.okul3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Adapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<Ogrenci> ogrListesi;
    TextView tvAd;
    TextView tvSoyad;
    TextView tvNumara;
    public Adapter(Activity activity, List<Ogrenci> ogrenciler) {
        //XML'i alıp View'a çevirecek inflater'ı örnekleyelim
        mInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        //gösterilecek liste
        ogrListesi = ogrenciler;

    }
    @Override
    public int getCount() {
        return ogrListesi.size();
    }

    @Override
    public Object getItem(int position) {
        return ogrListesi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        View satirView;
        satirView = mInflater.inflate(R.layout.satir,null);
        tvAd=(TextView)satirView.findViewById(R.id.tvAd);
        tvSoyad=(TextView)satirView.findViewById(R.id.tvSoyad);
        tvNumara=(TextView)satirView.findViewById(R.id.tvNumara);
        final Ogrenci ogrenci = ogrListesi.get(position);
        tvAd.setText(ogrenci.getOgrAd());
        tvSoyad.setText(ogrenci.getOgrSoyad());
        tvNumara.setText(ogrenci.getOgrNumara());

        return satirView;




        };

}
