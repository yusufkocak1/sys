package yube.com.siparisyonetimsistemi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yusuf on 26.04.2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.myViewHolder> {

    ArrayList <Contact> list=new ArrayList<>();

    public RecyclerAdapter(ArrayList<Contact> list) {
        this.list = list;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int i) {

       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent,false);
       myViewHolder myViewHolder=new myViewHolder(view);



        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(myViewHolder viewHolder, int position) {
        //sorunlu kısım burası burdan sonra patlıyor

        viewHolder.kullanici_adi.setText(list.get(position).getKullanici_adi());
        viewHolder.sifre.setText(list.get(position).getSifre());
        viewHolder.yetki.setText(list.get(position).getSifre());
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
