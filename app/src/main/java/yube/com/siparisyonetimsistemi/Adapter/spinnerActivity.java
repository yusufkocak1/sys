package yube.com.siparisyonetimsistemi.Adapter;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import yube.com.siparisyonetimsistemi.R;

/**
 * Created by yusuf on 26.04.2017.
 */

public class spinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

int pos;
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        spinner.setOnItemSelectedListener(this);
        this.pos=spinner.getSelectedItemPosition();
    }

    protected int getSelectedItem(){
        return pos;
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}