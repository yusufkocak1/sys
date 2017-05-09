package yube.com.siparisyonetimsistemi.Adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import yube.com.siparisyonetimsistemi.R;
import yube.com.siparisyonetimsistemi.getJson.kullaniciContact;

/**
 * Created by yusuf on 26.04.2017.
 */

public class userRecyclerAdapter extends RecyclerView.Adapter<userRecyclerAdapter.myViewHolder> {

    ArrayList <kullaniciContact> list=new ArrayList<>();

    public userRecyclerAdapter(ArrayList<kullaniciContact> list) {
        this.list = list;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int i) {

       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.user_recycler_item, parent,false);
       myViewHolder myViewHolder=new myViewHolder(view);



        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(myViewHolder viewHolder, int position) {
        //sorunlu kısım burası burdan sonra patlıyor

        viewHolder.kullanici_adi.setText(list.get(position).getKullanici_adi());
        viewHolder.sifre.setText(list.get(position).getSifre());
        String yetki = null;


        switch (list.get(position).getYetki()){
            case "0":
                viewHolder.itemView.setBackgroundColor(Color.rgb(211,47,47));
                yetki="Admin";
                break;
            case "1":
                yetki="Garson";
                viewHolder.itemView.setBackgroundColor(Color.rgb(48,63,159));
                break;
            case "2":
                yetki="Mutfak Personeli";
                viewHolder.itemView.setBackgroundColor(Color.rgb(76,175,80));
                break;
            case "3":
                yetki="Kasiyer";
                viewHolder.itemView.setBackgroundColor(Color.rgb(230,81,0));




        }
        viewHolder.yetki.setText(yetki);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class myViewHolder extends RecyclerView.ViewHolder{

        TextView kullanici_adi,sifre,yetki;

        public myViewHolder(View itemView) {
            super(itemView);
         kullanici_adi=(TextView) itemView.findViewById(R.id.kullanici_adi);
         sifre=(TextView) itemView.findViewById(R.id.sifre);
         yetki=(TextView) itemView.findViewById(R.id.yetki);



        }

    }//myVievHolder class

}//RecyclerAdpter class
