package yube.com.siparisyonetimsistemi;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AdminPanel extends AppCompatActivity {

    //Variables in this class
    EditText username,password;
    TextView textView;
    Button save;
    Spinner spinner;
    String insertUrl="http://10.210.22.243/kullanici_insert.php";
    String  selectUrl="http://10.210.22.243/kullanici_select.php";
    AlertDialog.Builder builder;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Contact> arrayList=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_panel);
        designElementadd();
        spinnerAdapter();
        displayData();

        save.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        setJsonBtn();
                                    }
        });




    }

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


   private void setJsonBtn(){

       final String usern;
       final String pass;
       final int yetki;

       usern = username.getText().toString();
       pass = password.getText().toString();

       yetki =spinner.getSelectedItemPosition();
       StringRequest stringRequest = new StringRequest(Request.Method.POST, insertUrl,
               new Response.Listener<String>() {
                   @Override
                   public void onResponse(String response) {

                       builder.setTitle("Server Response");
                       builder.setMessage("Response:" + response);
                       builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                   @Override
                                   public void onClick(DialogInterface dialog, int which) {

                                       username.setText("");
                                       password.setText("");

                                   }
                               }
                       );

                       AlertDialog alertDialog=builder.create();
                       alertDialog.show();

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
               params.put("yetki", String.valueOf(yetki));


               return params;
           }
       };

       MySingleton.getmInstance(AdminPanel.this).addTorequestque(stringRequest);

   }

   private  void displayData(){



   }

   private void spinnerAdapter(){
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
            R.array.yetki, android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);
   }

    private void designElementadd() {
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.pass);
        save = (Button) findViewById(R.id.save);
        textView = (TextView) findViewById(R.id.textView);
        spinner = (Spinner) findViewById(R.id.spinner);
        builder=new AlertDialog.Builder(AdminPanel.this);
        recyclerView=(RecyclerView) findViewById(R.id.recyclerview);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        BackgroundTask backgroundTask=new BackgroundTask(AdminPanel.this);
        arrayList=backgroundTask.getArrayList();
        recyclerAdapter=new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(recyclerAdapter);



    }}