package yube.com.siparisyonetimsistemi;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminPanel extends AppCompatActivity {
    EditText username,password;
    TextView textView;
    Button save;
    Long id;
    List<AdminPanel> liste=new ArrayList<>();
    public String kullanici;
    public String sifre;
    String url="http://192.168.0.150/kullanici_insert.php";
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_panel);


        designElementadd();
        final dataBase db=new dataBase(this);
        /*liste=db.KayıtGetir();
        AdminPanel obj=new AdminPanel();
        StringBuilder stringBuilder=new StringBuilder();
        for (AdminPanel adminPanel:liste){
            stringBuilder.append(obj.kullanici+" "+obj.sifre+"\n");
        }

textView.setText(stringBuilder);
*/
        builder=new AlertDialog.Builder(AdminPanel.this);

        save.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {


                                        final String usern, pass, yetki;

                                        usern = username.getText().toString();
                                        pass = password.getText().toString();
                                        yetki = "1";
                                        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                                                new Response.Listener<String>() {
                                                    @Override
                                                    public void onResponse(String response) {

                                                        builder.setTitle("Server Response");
                                                        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(DialogInterface dialog, int which) {

                                                                        username.setText("");
                                                                        password.setText("");

                                                                    }
                                                                }
                                                        );

                                                    }
                                                }, new Response.ErrorListener()

                                        {
                                            @Override
                                            public void onErrorResponse(VolleyError Error) {
                                                Toast.makeText(AdminPanel.this,"Error",Toast.LENGTH_SHORT);
                                            }
                                        }) {
                                            @Override
                                            protected Map<String, String> getParams() throws AuthFailureError {

                                                Map<String, String> params = new HashMap<String, String>();
                                                params.put("kullanici_adi", usern);
                                                params.put("sifre", pass);
                                                params.put("yetki", "1");


                                                return super.getParams();
                                            }
                                        };

                                        MySingleton.getmInstance(AdminPanel.this).addTorequestque(stringRequest);
                                    }


                                });}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if (id == R.id.back) {
            Intent cagir = new Intent(this, LoginPage.class);
            startActivity(cagir);
        }

        return AdminPanel.super.onOptionsItemSelected(item);
    }




    private void designElementadd() {
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.pass);
        save = (Button) findViewById(R.id.save);
        textView = (TextView) findViewById(R.id.textView);

    }}