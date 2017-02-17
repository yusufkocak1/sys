package yube.com.siparisyonetimsistemi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TablePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_page);
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
    }

    private void designElementadd() {
        


    }
}
