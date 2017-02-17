package yube.com.siparisyonetimsistemi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yusuf on 28.01.2017.
 */

public class dataBase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="sysistemi";
    private static final String TABLE_NAME="login";
    private static final int DATABASE_VERSION=1;



    private static final String username="username";
    private static final String password="password";
    private static final String id="id";

    public dataBase(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    String create_table="CREATE TABLE "+TABLE_NAME+
            " ("+id+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            username+" TEXT, "+
            password+" TEXT);";
        db.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    public long KayıtEkle(String username,String password) {

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(this.username,username);
        cv.put(this.password,password);

        long id=db.insert(TABLE_NAME,null,cv);
        db.close();
        return id;
    }

    public List KayıtGetir() {

        List list=new ArrayList();
        SQLiteDatabase db=this.getReadableDatabase();
       // String[] Sutunlar=new String[] {id,username,password};
        Cursor c=db.rawQuery("Select username,password from "+TABLE_NAME,null);
        int usernameno=c.getColumnIndex(username);
        int paswordno=c.getColumnIndex(password);
        for (c.moveToFirst();!c.moveToLast();c.moveToNext()){
        AdminPanel user=new AdminPanel();
            user.kullanici=c.getString(usernameno);
            user.sifre=c.getString(paswordno);
            list.add(user);
        }
        c.close();
        db.close();

        return list;
    }
}
