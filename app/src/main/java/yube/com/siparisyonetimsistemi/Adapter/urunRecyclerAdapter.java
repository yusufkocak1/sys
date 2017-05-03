package yube.com.siparisyonetimsistemi.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import yube.com.siparisyonetimsistemi.R;
import yube.com.siparisyonetimsistemi.getJson.urunContact;

/**
 * Created by yusuf on 3.05.2017.
 */

public class urunRecyclerAdapter extends RecyclerView.Adapter<urunRecyclerAdapter.myViewHolder> {

    ArrayList<urunContact> list = new ArrayList<>();

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
    public void onBindViewHolder(myViewHolder viewHolder, int position) {

        viewHolder.urun_adi.setText(list.get(position).getUrun_adi() + " " + list.get(position).getFiyat());


    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class myViewHolder extends RecyclerView.ViewHolder {
        int c;
        TextView urun_adi, kategori, fiyat;

        public myViewHolder(View itemView) {
            super(itemView);
            urun_adi = (TextView) itemView.findViewById(R.id.urunismi);
            kategori = (TextView) itemView.findViewById(R.id.sifre);
            fiyat = (TextView) itemView.findViewById(R.id.yetki);
            Button arti = (Button) itemView.findViewById(R.id.art);
            Button eksi = (Button) itemView.findViewById(R.id.ek);
            final TextView count = (TextView) itemView.findViewById(R.id.count);
            final TextView toplam = (TextView) itemView.findViewById(R.id.toplam);
            int c;
            arti.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setc(count.getText().toString());
                    count.setText(artir());
                }
            });
            eksi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setc(count.getText().toString());
                    count.setText(eksilt());
                }
            });


        }

        public void setc(String c) {
            this.c = Integer.parseInt(c.toString());
        }

        public int artir() {
            this.c++;
            return this.c;
        }

        public int eksilt() {
            this.c--;
            return this.c;
        }

    }//myVievHolder class

}//RecyclerAdpter class

