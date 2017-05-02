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
 * Created by yusuf on 26.04.2017.
 */

public class BackgroundTask {
    Context context;
    ArrayList<Contact> arrayList=new ArrayList<>();
    String  selectUrl="http://10.210.22.243/kullanici_select.php";

    public BackgroundTask(Context context) {
        this.context = context;
    }

    public ArrayList<Contact> getArrayList() {

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.POST, selectUrl, (String)null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                    int count=0;
                        while (count<response.length()){
                            try {
                                JSONObject jsonObject=response.getJSONObject(count);
                                Contact contact=new Contact(
                                        jsonObject.getString("kullanici_adi"),
                                        jsonObject.getString("sifre"),
                                        jsonObject.getString("yetki"));
                                arrayList.add(contact);
                                count++;


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"Error...",Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        }

        );
        MySingleton.getmInstance(context).addTorequestque(jsonArrayRequest);
        return arrayList;
    }


}
