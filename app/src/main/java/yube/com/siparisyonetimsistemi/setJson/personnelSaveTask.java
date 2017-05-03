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

public class personnelSaveTask {
    Context context;
    String ip;

    public personnelSaveTask(Context context) {
        this.context = context;
        ip = context.getString(R.string.ip);
    }

    String insertUrl = "http://10.210.22.243/personel.php";

    public void setJsonBtn(final String ad, final String soyad, final String telefon,
                           final String adres, final String tck_no, final String maas
    ) {


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
                params.put("ad", ad);
                params.put("soyad", soyad);
                params.put("telefon", telefon);
                params.put("adres", adres);
                params.put("tck_no", tck_no);
                params.put("maas", maas);


                return params;
            }
        };

        MySingleton.getmInstance(context).addTorequestque(stringRequest);//Bunu bıraz arastır

    }
}
