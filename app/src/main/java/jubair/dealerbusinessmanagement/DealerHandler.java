package jubair.dealerbusinessmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 6/11/2015.
 */
public class DealerHandler extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "Dealer Table";

    public static final String TABLE_DEALER = "dealer";

    public static final String ID_FIELD = "_id";

    public static final String NAME_FIELD = "name";

    public static final String PASSWORD_FIELD = "password";

    public String TABLE_DEALER_SQL = "CREATE TABLE " + TABLE_DEALER +  "(" + ID_FIELD + " INTEGER PRIMARY KEY, " + NAME_FIELD + " TEXT," + PASSWORD_FIELD + " TEXT" + ")";

    public DealerHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLE_DEALER_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DEALER);
        onCreate(db);
    }

    public void insert(Dealer dealer){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME_FIELD, dealer.getName());
        values.put(PASSWORD_FIELD, dealer.getPassword());

        db.insert(TABLE_DEALER, null, values);
        db.close();
    }

    public List<Dealer> getAllDealer(){
        List<Dealer> list = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_DEALER, null, null, null, null, null, null);
        if(cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                int id_index = cursor.getInt(cursor.getColumnIndex(ID_FIELD));
                String name = cursor.getString(cursor.getColumnIndex(NAME_FIELD));
                String password = cursor.getString(cursor.getColumnIndex(PASSWORD_FIELD));

                list.add(new Dealer(id_index, name, password));
                cursor.moveToNext();
            }
        }

        cursor.close();
        db.close();

        return list;
    }

    public int getID(Dealer dealer){
        int id=-1 ;
        String name = dealer.getName();
        String password = dealer.getPassword();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_DEALER,null,null,null,null,null,null);

        if(cursor!=null && cursor.getCount()>0) {
            cursor.moveToFirst();
            for(int i=0; i<cursor.getCount();i++)
            {
                int id_index = cursor.getInt(cursor.getColumnIndex(ID_FIELD));
                String cname = cursor.getString(cursor.getColumnIndex(NAME_FIELD));
                String cpassword = cursor.getString(cursor.getColumnIndex(PASSWORD_FIELD));
                if(!cname.equals(name) && !cpassword.equals(password)) {
                    id = id_index;
                    break;
                }
                cursor.moveToNext();
            }
        }
        com

        cursor.close();
        db.close();
        return id;
    }

}
