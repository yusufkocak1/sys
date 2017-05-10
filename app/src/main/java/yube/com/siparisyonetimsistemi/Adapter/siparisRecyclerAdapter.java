package yube.com.siparisyonetimsistemi.Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import yube.com.siparisyonetimsistemi.R;
import yube.com.siparisyonetimsistemi.getJson.siparisgosterContact;
import yube.com.siparisyonetimsistemi.setJson.updatedurumTask;

/**
 * Created by yusuf on 3.05.2017.
 */

public class siparisRecyclerAdapter extends RecyclerView.Adapter<siparisRecyclerAdapter.myViewHolder> {
    int id = 0;
    ArrayList<siparisgosterContact> list = new ArrayList<>();
    Activity activity;
 private String urunadi;
    boolean running=false;

    public siparisRecyclerAdapter(ArrayList<siparisgosterContact> list, Activity activity) {

        this.activity=activity;
        this.list = list;
    }

    @Override
    public siparisRecyclerAdapter.myViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.siparis_goster_recycler_item, parent, false);
        siparisRecyclerAdapter.myViewHolder myViewHolder = new siparisRecyclerAdapter.myViewHolder(view);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final siparisRecyclerAdapter.myViewHolder viewHolder, final int position) {
        viewHolder.urun_adi.setText(list.get(position).getUrun_adi());
        viewHolder.fiyat.setText(list.get(position).getFiyat());
        viewHolder.masano.setText(list.get(position).getMasa_id());








                viewHolder.urun_adi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        running=true;
                        viewAlert dialog=new viewAlert();
                        dialog.showDialog(activity,list,position);

                        running=false;
                    }
                });

        running=true;


        switch (list.get(position).getDurum()) {
            case "0":
                viewHolder.itemView.setBackgroundColor(Color.rgb(211, 47, 47));
                break;
            case "1":
                viewHolder.itemView.setBackgroundColor(Color.rgb(48, 63, 159));
                break;
            case "2":
                viewHolder.itemView.setBackgroundColor(Color.rgb(76, 175, 80));
        }
urunadi=viewHolder.urun_adi.getText().toString();

    }


    @Override
    public int getItemCount() {
        return list.size();
    }




    public static class myViewHolder extends RecyclerView.ViewHolder {


      public  TextView urun_adi, fiyat, masano;


        public myViewHolder(View itemView) {
            super(itemView);

            urun_adi = (TextView) itemView.findViewById(R.id.UrunAdi);
            fiyat = (TextView) itemView.findViewById(R.id.UrunFiyat);
            masano = (TextView) itemView.findViewById(R.id.masa_id);


        }


    }//myVievHolder class


    class viewAlert {

TextView masaid,personelid,urunid,urunadi,miktar,fiyat,sipariszamani;
        Button onayla;

        public void showDialog(Activity activity, final ArrayList<siparisgosterContact> list, final int position) {
            final Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(true);
            dialog.setContentView(R.layout.siparis_panel_alert);
            masaid=(TextView)dialog.findViewById(R.id.masaid);
            personelid=(TextView)dialog.findViewById(R.id.personelid);
            urunid=(TextView)dialog.findViewById(R.id.urunid);
            urunadi=(TextView)dialog.findViewById(R.id.urunadi);
            miktar=(TextView)dialog.findViewById(R.id.urunmiktar);
            fiyat=(TextView)dialog.findViewById(R.id.toplamfiyat);
            sipariszamani=(TextView)dialog.findViewById(R.id.siparizamani);
            onayla=(Button)dialog.findViewById(R.id.btnonay);
            final updatedurumTask updatedurum=new updatedurumTask(activity);
            masaid.setText(masaid.getText().toString()+list.get(position).getMasa_id());
            personelid.setText(personelid.getText().toString()+list.get(position).getPersonel_id());
            urunid.setText(urunid.getText().toString()+list.get(position).getUrun_id());
            urunadi.setText(urunadi.getText().toString()+list.get(position).getUrun_adi());
            miktar.setText(miktar.getText().toString()+list.get(position).getAdet());
            fiyat.setText(fiyat.getText().toString()+list.get(position).getFiyat());
            sipariszamani.setText(sipariszamani.getText().toString()+list.get(position).getSiparis_zamani());
            onayla.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    updatedurum.setJsonBtn(list.get(position).getSiparis_id(),"1");
                    dialog.dismiss();
                }
            });
            dialog.show();

        }
    }//RecyclerAdpter class

}