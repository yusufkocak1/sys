package yube.com.siparisyonetimsistemi.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import yube.com.siparisyonetimsistemi.R;
import yube.com.siparisyonetimsistemi.getJson.siparisContact;
import yube.com.siparisyonetimsistemi.getJson.urunContact;

/**
 * Created by yusuf on 3.05.2017.
 */

public class urunRecyclerAdapter extends RecyclerView.Adapter<urunRecyclerAdapter.myViewHolder> {
    int id=1;
    ArrayList<urunContact> list = new ArrayList<>();
    ArrayList<siparisContact> siparislist= new ArrayList<>();
    public urunRecyclerAdapter(ArrayList<urunContact> list) {
        this.list = list;
    }
    @Override
    public urunRecyclerAdapter.myViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.siparis_al_recycler_item, parent, false);
        urunRecyclerAdapter.myViewHolder myViewHolder = new urunRecyclerAdapter.myViewHolder(view);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final myViewHolder viewHolder, final int position) {

        viewHolder.urun_adi.setText(list.get(position).getUrun_adi() + " " + list.get(position).getFiyat());
       viewHolder.arti.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               viewHolder.count.setText(artir(viewHolder.count.getText().toString()));
               viewHolder.toplam.setText(fiyatgoster(viewHolder.count.getText().toString(),list.get(position).getFiyat()));

           }
       });
        viewHolder.eksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(viewHolder.count.getText().toString())>0){
                viewHolder.count.setText(eksilt(viewHolder.count.getText().toString()));
                viewHolder.toplam.setText(fiyatgoster(viewHolder.count.getText().toString(),list.get(position).getFiyat()));
            }}
        });


       if(viewHolder.selectUrun.isChecked()){
          siparislist.get(id).setUrun_adi(viewHolder.urun_adi.getText().toString());
          siparislist.get(id).setAdet(viewHolder.count.getText().toString());
          siparislist.get(id).setFiyat(viewHolder.fiyat.toString());
           siparislist.get(id).setUrun_id(list.get(position).getId());
           id++;
       }
       if(!viewHolder.selectUrun.isChecked()){

       }

    }



    private String fiyatgoster(String text, String fiyat) {
        return   String.valueOf(Integer.parseInt(text)*Integer.parseInt(fiyat));
    }

    int c;


    public String artir(String c) {
        int count =Integer.parseInt(c);
        count++;

        return String.valueOf(count);
    }

    public String eksilt(String c) {
        int count =Integer.parseInt(c);
        count--;

        return String.valueOf(count);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class myViewHolder extends RecyclerView.ViewHolder {

        TextView urun_adi, kategori, fiyat;
        Button arti,eksi;
        CheckBox selectUrun;

        TextView count = (TextView) itemView.findViewById(R.id.count);
        TextView toplam = (TextView) itemView.findViewById(R.id.toplam);
        public myViewHolder(View itemView) {
            super(itemView);
            selectUrun=(CheckBox) itemView.findViewById(R.id.uruncheckbox);
            urun_adi = (TextView) itemView.findViewById(R.id.urunismi);
            kategori = (TextView) itemView.findViewById(R.id.sifre);
            fiyat = (TextView) itemView.findViewById(R.id.yetki);
            arti = (Button) itemView.findViewById(R.id.art);
            eksi = (Button) itemView.findViewById(R.id.ek);








        }









    }//myVievHolder class

}//RecyclerAdpter class

