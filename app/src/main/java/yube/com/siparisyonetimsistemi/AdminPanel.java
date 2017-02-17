package yube.com.siparisyonetimsistemi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AdminPanel extends AppCompatActivity {
    EditText username,password;
    TextView textView;
    Button save;
    Long id;
    List<AdminPanel> liste=new ArrayList<>();
    public String kullanici;
    public String sifre;

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

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             id=db.KayıtEkle(username.getText().toString(),password.getText().toString());
                if(id==-1){
                   Toast.makeText(AdminPanel.this,"kayıt başarısız..",Toast.LENGTH_SHORT).show();
                }
                else if (id==1)
                   Toast.makeText(AdminPanel.this,"kayıt başarılı..",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void designElementadd() {
        username=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.pass);
        save=(Button) findViewById(R.id.save);
        textView=(TextView) findViewById(R.id.textView);

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
        else if (id== R.id.back){
            Intent cagir= new Intent(this, LoginPage.class);
            startActivity(cagir);
        }

        return super.onOptionsItemSelected(item);
    }


}
