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
public class ClientHandler extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "CLIENT_TABLE";
    public static final String TABLE_CLIENT = "CLIENT";
    public static final String ID = "_id";
    public static final String CLIENT_NAME = "name";
    public static final String CLIENT_EMAIL = "email";

    public static final String CLIENT_ADDRESS = "address";
    public static final String  CLIENT_PHONE_NUMBER = "phone number";
    public static final String DEALER_FIELD = "dealerId";

    public String CREATE_CLIENT_TABLE = "CREATE TABLE " + TABLE_CLIENT + " (" + ID + " INTEGER PRIMARY KEY, " +
            CLIENT_NAME + " TEXT, " + CLIENT_EMAIL + " TEXT, " + CLIENT_ADDRESS + " TEXT, " + CLIENT_PHONE_NUMBER + " TEXT, " + DEALER_FIELD + " INTEGER" + ")";

    public ClientHandler(Context context){

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLIENT);

        onCreate(db);
    }


    public void insert(Client client){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(CLIENT_NAME, client.getName());
        contentValues.put(CLIENT_EMAIL, client.getEmail());
        contentValues.put(CLIENT_ADDRESS, client.getAddress());
        contentValues.put(CLIENT_PHONE_NUMBER, client.getPhoneNumber());
        contentValues.put(DEALER_FIELD, client.getDealersId());

        db.insert(TABLE_CLIENT, null, contentValues);
        db.close();
    }

    public void update(int id, String name, String email, String address, String phoneNumber, int dealersId){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CLIENT_NAME, name);
        values.put(CLIENT_EMAIL, email);
        values.put(CLIENT_ADDRESS, address);
        values.put(CLIENT_PHONE_NUMBER, phoneNumber);
        values.put(DEALER_FIELD, dealersId);


        db.update(TABLE_CLIENT, values, "=" + id, null);
        db.close();
    }

   public List<Client> getAllClients(int dealersId){
        List<Client> list = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_CLIENT, null, null, null, null, null, null);
        if(cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                int id_index = cursor.getInt(cursor.getColumnIndex(ID));
                String name = cursor.getString(cursor.getColumnIndex(CLIENT_NAME));
                String email = cursor.getString(cursor.getColumnIndex(CLIENT_EMAIL));
                String address = cursor.getString(cursor.getColumnIndex(CLIENT_ADDRESS));
                String phoneNumber = cursor.getString(cursor.getColumnIndex(CLIENT_PHONE_NUMBER));
                int dealerId = cursor.getInt(cursor.getColumnIndex(DEALER_FIELD));

                if(dealerId==dealersId) {
                    list.add(new Client(id_index, name, email, address, phoneNumber, dealerId));
                }
                cursor.moveToNext();
            }
        }

        cursor.close();
        db.close();

        return list;
    }

}
