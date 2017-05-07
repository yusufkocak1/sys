package yube.com.siparisyonetimsistemi.setJson;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import yube.com.siparisyonetimsistemi.MySingleton;
import yube.com.siparisyonetimsistemi.R;

/**
 * Created by yusuf on 2.05.2017.
 */

public class siparisTask {
    Context context;
    String ip;

    public siparisTask(Context context) {
        ip = context.getString(R.string.ip);
        this.context = context;
    }

    String insertUrl = "http://192.168.0.150/siparis.php";

    public void setJsonBtn(final String personel_id, final String urun_id, final String siparis_zamani, final String miktar, final String fiyat, final String durum, final String aciklama) {


        StringRequest stringRequest = new StringRequest(Request.Method.POST, insertUrl,/*php sayfasına ulasmak ıcın yazıyoruz*/
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setTitle("Server Response");
                        builder.setMessage("Response:" + response);
                        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {


                                    }
                                }
                        );

                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();

                    }
                }, new Response.ErrorListener()

        {
            @Override
            public void onErrorResponse(VolleyError Error) {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();//Arraylıstın aga babası
                params.put("Personel_id", personel_id);
                params.put("urun_id",urun_id);
                params.put("siparis zamani", siparis_zamani);
                params.put("fiyat",fiyat);
                params.put("miktar", miktar);
                params.put("durum",durum);
                params.put("aciklama",aciklama);


                return params;
            }
        };

        MySingleton.getmInstance(context).addTorequestque(stringRequest);//Bunu bıraz arastır

    }
}
