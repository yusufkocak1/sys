package yube.com.siparisyonetimsistemi;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import java.util.ArrayList;

import yube.com.siparisyonetimsistemi.Adapter.siparisRecyclerAdapter;
import yube.com.siparisyonetimsistemi.getJson.siparisTask;
import yube.com.siparisyonetimsistemi.getJson.siparisgosterContact;

import static java.lang.Thread.sleep;

public class SiparisPanel extends AppCompatActivity {
    public Thread thread;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<siparisgosterContact> arrayList = new ArrayList<>();//Cekilen kullanıcı verılerı arraylıste eklenıyor.bu degıskenı onun ıcın kullanacagım.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siparis_panel);
        recyclerView = (RecyclerView) findViewById(R.id.siparisReceycler);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        siparisTask siparisTask = new siparisTask(SiparisPanel.this);
        arrayList = siparisTask.getArrayList();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        recyclerAdapter = new siparisRecyclerAdapter(arrayList,SiparisPanel.this);
        recyclerView.setAdapter(recyclerAdapter);


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
        else if(id==R.id.action_share){
            finish();
            startActivity(getIntent());
        }

        return super.onOptionsItemSelected(item);
    }

}

 class  viewAlert{

    public void showDialog(Activity activity){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.siparis_panel_alert);



    }
}
