package yube.com.siparisyonetimsistemi.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import yube.com.siparisyonetimsistemi.R;
import yube.com.siparisyonetimsistemi.getJson.siparisAlContact;

/**
 * Created by yusuf on 3.05.2017.
 */

public class siparisAlRecyclerAdapter extends RecyclerView.Adapter<siparisAlRecyclerAdapter.myViewHolder> {

    ArrayList<siparisAlContact> list=new ArrayList<>();
    public siparisAlRecyclerAdapter(ArrayList<siparisAlContact> list) {
        this.list=list;
    }

    @Override
    public siparisAlRecyclerAdapter.myViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.siparis_al_recycler_item, parent,false);
        siparisAlRecyclerAdapter.myViewHolder myViewHolder=new siparisAlRecyclerAdapter.myViewHolder(view);



        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(siparisAlRecyclerAdapter.myViewHolder viewHolder, int position) {





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

