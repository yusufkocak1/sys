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

public class urunTask {
    Context context;
    ArrayList<urunContact> arrayList = new ArrayList<>();
    String selectUrl = "http://192.168.0.150/sorgu_urunler.php";

    public urunTask(Context context) {
        this.context = context;
    }

    public ArrayList<urunContact> getArrayList() {

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, selectUrl, (String) null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        int count = 0;
                        while (count < response.length()) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(count);
                                urunContact urunContact = new urunContact(
                                        jsonObject.getString("urun_adi"),
                                        jsonObject.getString("kategori"),
                                        jsonObject.getString("fiyat"),
                                        jsonObject.getString("id")

                                );
                                arrayList.add(urunContact);
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
