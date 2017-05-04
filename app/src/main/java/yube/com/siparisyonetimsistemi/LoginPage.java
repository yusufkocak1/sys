package yube.com.siparisyonetimsistemi;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import yube.com.siparisyonetimsistemi.getJson.kullaniciContact;
import yube.com.siparisyonetimsistemi.getJson.KullaniciTask;

public class LoginPage extends Activity {


    private static final String MY_PREFS_NAME = "login";
    //design variable
    EditText user, password;
    Button login;
    ArrayList<kullaniciContact> kullanicilar = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        //Full screen


        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // Top system menu
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        //design element adding method call
        designElementadd();


        KullaniciTask task = new KullaniciTask(LoginPage.this);
        kullanicilar = task.getArrayList();
        login.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                //  connect();
                boolean temp = true;
                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                editor.putString("user", user.getText().toString());

                editor.commit();
                if (kullanicilar.size() > 0) {
                    for (int i = 0; i < kullanicilar.size(); i++) {


                        if (user.getText().toString().equals(kullanicilar.get(i).getKullanici_adi()) && password.getText().toString().equals(kullanicilar.get(i).getSifre()) && kullanicilar.get(i).getYetki().toString().equals("1")) {
                            temp = false;
                            Intent cagir = new Intent("yube.com.siparisyonetimsistemi.TABLE");
                            startActivity(cagir);
                        } else if (user.getText().toString().equals(kullanicilar.get(i).getKullanici_adi()) && password.getText().toString().equals(kullanicilar.get(i).getSifre()) && kullanicilar.get(i).getYetki().toString().equals("0")) {
                            temp = false;
                            Intent adminCagir = new Intent("yube.com.siparisyonetimsistemi.ADMINPANEL");
                            startActivity(adminCagir);

                        }
                    }
                    if (temp) {
                        ViewDialogL alert = new ViewDialogL();
                        alert.showDialog(LoginPage.this, "Şifre yanlış");
                    }
                }
                else{
                    ViewDialogL alert = new ViewDialogL();
                    alert.showDialog(LoginPage.this, "Veritabanı bağlantısı başarısız");
                }

            }
        });



    }


    private void designElementadd() {
        user = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.pass);
        login = (Button) findViewById(R.id.login);


    }


}

class ViewDialogL {

    public void showDialog(Activity activity, String msg) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.alertdialog);

        TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
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