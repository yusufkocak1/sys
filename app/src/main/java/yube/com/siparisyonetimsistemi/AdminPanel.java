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
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import yube.com.siparisyonetimsistemi.Adapter.userRecyclerAdapter;
import yube.com.siparisyonetimsistemi.getJson.KullaniciTask;
import yube.com.siparisyonetimsistemi.getJson.kullaniciContact;
import yube.com.siparisyonetimsistemi.setJson.personnelSaveTask;
import yube.com.siparisyonetimsistemi.setJson.userSaveTask;

public class AdminPanel extends AppCompatActivity {

    //Variables in this class


    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<kullaniciContact> arrayList = new ArrayList<>();//Cekilen kullanıcı verılerı arraylıste eklenıyor.bu degıskenı onun ıcın kullanacagım.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_panel);
        designElementadd();
        displayData();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);//Ust taraf menu


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
        } else if (id == R.id.action_search) {
            dialogusersave dialog = new dialogusersave();
            dialog.showDialog(this);
        }
        return AdminPanel.super.onOptionsItemSelected(item);
    }


    private void displayData() {


    }


    private void designElementadd() {

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        KullaniciTask kullaniciTask = new KullaniciTask(AdminPanel.this);
        arrayList = kullaniciTask.getArrayList();
        recyclerAdapter = new userRecyclerAdapter(arrayList);
        recyclerView.setAdapter(recyclerAdapter);


    }
}

class dialogusersave {

    Spinner spinner;

    public void showDialog(Activity activity) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.alert);
        final EditText username = (EditText) dialog.findViewById(R.id.userAlert);
        final EditText password = (EditText) dialog.findViewById(R.id.passAlert);
        spinner = (Spinner) dialog.findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(activity,
                R.array.yetki, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        final userSaveTask userSaveTask = new userSaveTask(activity);
        final personnelSaveTask personnelSaveTask = new personnelSaveTask(activity);
        Button save = (Button) dialog.findViewById(R.id.save);
        Button cancel = (Button) dialog.findViewById(R.id.cancel);
        final EditText ad=(EditText) dialog.findViewById(R.id.nameAlert);
        final EditText soyad=(EditText) dialog.findViewById(R.id.surnameAlert);
        final EditText tel=(EditText) dialog.findViewById(R.id.telAlert);
        final EditText adres=(EditText) dialog.findViewById(R.id.adresAlert);
        final EditText tck_no=(EditText) dialog.findViewById(R.id.tckAlert);
        final EditText maas=(EditText) dialog.findViewById(R.id.maasAlert);



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userSaveTask.setJsonBtn(username.getText().toString(), password.getText().toString(), spinner.getSelectedItemPosition()
                        );
                personnelSaveTask.setJsonBtn(ad.getText().toString(),soyad.getText().toString(),tel.getText().toString(),
                adres.getText().toString(),tck_no.getText().toString(),maas.getText().toString()
                );
                dialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


        dialog.show();

    }
}