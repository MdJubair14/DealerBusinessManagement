package jubair.dealerbusinessmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

/**
 * Created by hp on 6/11/2015.
 */
public class ClientHandler extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "";
    public static final String TABLE_CLIENT = "";
    public static final String ID = "_id";
    public static final String CLIENT_NAME = "name";
    public static final String CLIENT_EMAIL = "abc@gmail.com";
    public static final String CLIENT_ADDRESS = "DHAKA UNIVERSITY";
    public static final String  CLIENT_PHONE_NUMBER = "01738196697";

    public ClientHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CLIENT_TABLE = "CREATE TABLE " + TABLE_CLIENT + " (" + ID + " INTEGER PRIMARY KEY" +
                CLIENT_NAME + " TEXT" + CLIENT_EMAIL + " TEXT" + CLIENT_ADDRESS + " TEXT" + CLIENT_PHONE_NUMBER + " TEXT" + ")";
        db.execSQL(CREATE_CLIENT_TABLE);
    }

    /**
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE CLIENT " + TABLE_CLIENT);
    }


    public void addClient(Client client){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(CLIENT_NAME, client.getName());
        contentValues.put(CLIENT_EMAIL, client.getEmail());
        contentValues.put(CLIENT_ADDRESS, client.getAddress());
        contentValues.put(CLIENT_PHONE_NUMBER, client.getPhoneNumber());

        db.insert(TABLE_CLIENT, null, contentValues);
        db.close();
    }

    /*public Client getClient(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CLIENT, new String[] {CLIENT_NAME, CLIENT_EMAIL, CLIENT_ADDRESS, CLIENT_PHONE_NUMBER}, KEY_ID + "=?", new String[] {String.valueOf(id) }  )

    }

    public List<Client> getAllClient(){

    }

    public int getTotalClient(){

    }

    public int updateClient(Client client){

    }

    public void removeClient(Client client){

    }*/

}
