package yube.com.siparisyonetimsistemi;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TablePage extends AppCompatActivity implements View.OnClickListener {
    private static final String MY_PREFS_NAME ="login" ;
    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10;

    ListView listemiz=null;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;



    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_page);
        designElementadd();
        //Full screen

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String restoredText = prefs.getString("text", null);

            username = prefs.getString("user", "No name defined");//"No name defined" is the default value.
        String[] ulkeler =
                {"Türkiye", "Almanya", "Avusturya", "Amerika","İngiltere",
                        "Macaristan", "Yunanistan", "Rusya", "Suriye", "İran", "Irak",
                        "Şili", "Brezilya", "Japonya", "Portekiz", "İspanya",
                        "Makedonya", "Ukrayna", "İsviçre"};
        //(A) adımı
        listemiz=new ListView(this);

        //(B) adımı
        ArrayAdapter<String> veriAdaptoru=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, ulkeler);

        //(C) adımı
        listemiz.setAdapter(veriAdaptoru);

        listemiz.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ViewGroup vg=(ViewGroup) view;
                TextView txt=(TextView) findViewById(R.id.txtitem);
                Toast.makeText(TablePage.this,txt.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });








    }



    @Override
    public void onClick(View v) {
        // Perform action on click
        switch (v.getId()) {
            case R.id.button: {

                showDialog(TablePage.this, "masa no:" + 1);

                break;
            }
            case R.id.button2: {
                showDialog(TablePage.this, "masa no:2");
                break;
            }
            case R.id.button3: {
                showDialog(TablePage.this, "" + R.id.button3);
                break;
            }
            case R.id.button4: {
                showDialog(TablePage.this, "" + R.id.button4);
                break;
            }
            case R.id.button5: {

                break;
            }
            case R.id.button6: {

                break;
            }
            case R.id.button7: {

                break;
            }
            case R.id.button9: {

                break;
            }
            case R.id.button10: {

                break;
            }
            case R.id.button11: {

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


    public void showDialog(Activity activity, String msg) {



        AlertDialog.Builder builder=new AlertDialog.Builder(TablePage.this);
        builder.setCancelable(true);

        ListView liste=(ListView) findViewById(R.id.listview);
        liste=listemiz;
builder.setView(R.layout.table_alert_dialog);
        final Dialog dialog =builder.create();
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);



      // dialog.setContentView(R.layout.table_alert_dialog);

        TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
        TextView user = (TextView) dialog.findViewById(R.id.usern);
        user.setText(username);
        text.setText(msg);
        Button dialogButton = (Button) dialog.findViewById(R.id.btn_dialog);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
      });

        dialog.show();

    }



}
