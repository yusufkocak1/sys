package yube.com.siparisyonetimsistemi;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

import yube.com.siparisyonetimsistemi.Adapter.urunRecyclerAdapter;
import yube.com.siparisyonetimsistemi.getJson.siparisContact;
import yube.com.siparisyonetimsistemi.getJson.urunContact;
import yube.com.siparisyonetimsistemi.getJson.urunTask;
import yube.com.siparisyonetimsistemi.setJson.siparisTask;

public class TablePage extends AppCompatActivity implements View.OnClickListener {
    private static final String MY_PREFS_NAME ="login" ;
    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10;



    private dialogsiparis alert=new dialogsiparis();
    urunTask urunTask = new urunTask(this);
    ArrayList<urunContact> arrayList = urunTask.getArrayList();

    String username,id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_page);
        designElementadd();
        //Full screen

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        username = prefs.getString("user", "No name defined");
        id=prefs.getString("id","No id defined");












    }



    @Override
    public void onClick(View v) {
        // Perform action on click
        switch (v.getId()) {
            case R.id.button: {

               alert.showDialog(TablePage.this, "masa no:" + 1,id,username,arrayList);

                break;
            }
            case R.id.button2: {
                alert.showDialog(TablePage.this, "masa no:"+2,id,username,arrayList);
                break;
            }
            case R.id.button3: {
                alert.showDialog(TablePage.this, "masa no:" +3,id,username,arrayList);
                break;
            }
            case R.id.button4: {
                alert.showDialog(TablePage.this, "masa no:" + 4,id,username,arrayList);
                break;
            }
            case R.id.button5: {
                alert.showDialog(TablePage.this, "masa no:" + 5,id,username,arrayList);
                break;
            }
            case R.id.button6: {
                alert.showDialog(TablePage.this, "masa no:" + 6,id,username,arrayList);
                break;
            }
            case R.id.button7: {
                alert.showDialog(TablePage.this, "masa no:" + 7,id,username,arrayList);
                break;
            }
            case R.id.button9: {
                alert.showDialog(TablePage.this, "masa no:" + 8,id,username,arrayList);
                break;
            }
            case R.id.button10: {
                alert.showDialog(TablePage.this, "masa no:" + 9,id,username,arrayList);
                break;
            }
            case R.id.button11: {
                alert.showDialog(TablePage.this, "masa no:" + 10,id,username,arrayList);
                break;
            }


        }
    }

    private void designElementadd() {
        bt1 = (Button) findViewById(R.id.button);
        bt2 = (Button) findViewById(R.id.button2);
        bt3 = (Button) findViewById(R.id.button3);
        bt4 = (Button) findViewById(R.id.button4);
        bt5 = (Button) findViewById(R.id.button5);
        bt6 = (Button) findViewById(R.id.button6);
        bt7 = (Button) findViewById(R.id.button7);
        bt8 = (Button) findViewById(R.id.button11);
        bt9 = (Button) findViewById(R.id.button9);
        bt10 = (Button) findViewById(R.id.button10);
        // table_no=(TextView) findViewById(R.id.table_no);


        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);
        bt10.setOnClickListener(this);


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
        } else if (id == R.id.back) {
            Intent cagir = new Intent(this, LoginPage.class);
            startActivity(cagir);
        }

        return super.onOptionsItemSelected(item);
    }



}
class dialogsiparis {


    TextView m_no,user;
    Button siparis_onay;


    public void showDialog(final Activity activity, String masano, final String id, String username, final ArrayList arrayList) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.table_alert_dialog);
        user=(TextView) dialog.findViewById(R.id.garsonusername);
        m_no=(TextView) dialog.findViewById(R.id.masa_no);
        siparis_onay=(Button) dialog.findViewById(R.id.siparis_onay);




        RecyclerView recyclerView = (RecyclerView) dialog.findViewById(R.id.urunrecycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        urunRecyclerAdapter recyclerAdapter = new urunRecyclerAdapter(arrayList);
        recyclerView.setAdapter(recyclerAdapter);
        final ArrayList <siparisContact> siparis=new ArrayList<>();
        final siparisTask sipariAl=new siparisTask(activity);

        user.setText(username);
        m_no.setText(masano);
        Date d = new Date();
        final CharSequence s  = DateFormat.format("EEEE, MMMM d, yyyy ", d.getTime());


        siparis_onay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                for (int i=0;i<siparis.size();i++)
                      {
                    sipariAl.setJsonBtn(id,siparis.get(i).getUrun_id(),s.toString(),siparis.get(i).getAdet(),siparis.get(i).getFiyat(),"0","non");

                }
                dialog.dismiss();
            }
        });



        dialog.show();


    }



}



