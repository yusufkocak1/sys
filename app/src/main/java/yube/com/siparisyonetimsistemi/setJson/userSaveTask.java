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

public class userSaveTask {
    Context context;
    String ip;

    public userSaveTask(Context context) {
        ip = context.getString(R.string.ip);
        this.context = context;
    }

    String insertUrl = "http://" + ip + "/kullanici_insert.php";

    public void setJsonBtn(final String usern, final String pass, final int yetki) {


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
                params.put("kullanici_adi", usern);
                params.put("sifre", pass);
                params.put("yetki", String.valueOf(yetki));


                return params;
            }
        };

        MySingleton.getmInstance(context).addTorequestque(stringRequest);//Bunu bıraz arastır

    }
}
