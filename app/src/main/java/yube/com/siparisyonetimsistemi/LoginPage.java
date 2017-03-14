package yube.com.siparisyonetimsistemi;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginPage extends Activity {



    //design variable
    EditText user,password;
    Button login;

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
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               connect();


//               if( user.getText().toString().equals("yusuf") && password.getText().toString().equals("yusuf326")){
//                    Intent cagir=new Intent("yube.com.siparisyonetimsistemi.TABLE");
//                    startActivity(cagir);
//               }else if(user.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
//                   Intent adminCagir=new Intent("yube.com.siparisyonetimsistemi.ADMINPANEL");
//                   startActivity(adminCagir);
//               }
//               else if(user.getText().toString().equals("Bx3fn") && password.getText().toString().equals("0325")){
//                   Intent adminCagir=new Intent(LoginPage.this,AdminPanel.class);
//                   startActivity(adminCagir);
//               }
//
//                else{
//                   ViewDialog alert = new ViewDialog();
//                   alert.showDialog(LoginPage.this, "Şifre yanlış");
//               }
//
           }
   });


    }



    private void designElementadd() {
        user=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.pass);
        login=(Button) findViewById(R.id.login);


    }
    private void connect(){
        HttpURLConnection connection=null;
        BufferedReader reader=null;
        try {
            URL url=new URL("192.168.1.40:5432/postgres");
            connection =(HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream stream=connection.getInputStream();
            reader=new BufferedReader(new InputStreamReader(stream));
            String line="";
            StringBuffer buffer=new StringBuffer();
            while((line=reader.readLine())!=null){
                buffer.append(line);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if (connection!=null)
                connection.disconnect();
            if (reader!=null)
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }
}
class ViewDialog {

    public void showDialog(Activity activity, String msg){
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