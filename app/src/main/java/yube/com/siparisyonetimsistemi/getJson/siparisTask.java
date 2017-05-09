package yube.com.siparisyonetimsistemi.getJson;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import yube.com.siparisyonetimsistemi.MySingleton;

/**
 * Created by yusuf on 3.05.2017.
 */

public class siparisTask {
    Context context;
    ArrayList<siparisgosterContact> arrayList = new ArrayList<>();
    String selectUrl = "http://192.168.0.150/sorgusiparis.php";

    public siparisTask(Context context) {
        this.context = context;
    }

    public ArrayList<siparisgosterContact> getArrayList() {

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, selectUrl, (String) null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        int count = 0;
                        while (count < response.length()) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(count);
                                siparisgosterContact siparisgosterContact = new siparisgosterContact(
                                        jsonObject.getString("personel_id"),
                                        jsonObject.getString("masa_id"),
                                        jsonObject.getString("miktar"),
                                        jsonObject.getString("urun_id"),
                                        jsonObject.getString("urun_adi"),
                                        jsonObject.getString("fiyat"),
                                        jsonObject.getString("siparis_zamani"),
                                        jsonObject.getString("durum")

                                );
                                arrayList.add(siparisgosterContact);
                                count++;


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error...", Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        }

        );
        MySingleton.getmInstance(context).addTorequestque(jsonArrayRequest);
        return arrayList;
    }


}
