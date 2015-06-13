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
    public static final String CLIENT_ADDRESS = "address";
    public static final String  CLIENT_CONTACT_INFO = "info";
    public static final String DEALER_FIELD = "dealerId";

    public String CREATE_CLIENT_TABLE = "CREATE TABLE " + TABLE_CLIENT + " (" + ID + " INTEGER PRIMARY KEY, " +
            CLIENT_NAME + " TEXT, " + CLIENT_ADDRESS + " TEXT, " + CLIENT_CONTACT_INFO + " TEXT, " + DEALER_FIELD + " INTEGER" + ")";

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
        contentValues.put(CLIENT_ADDRESS, client.getAddress());
        contentValues.put(CLIENT_CONTACT_INFO, client.getContactInfo());
        contentValues.put(DEALER_FIELD, client.getDealersId());

        db.insert(TABLE_CLIENT, null, contentValues);
        db.close();
    }

    public void update(Client client){
        SQLiteDatabase db = this.getWritableDatabase();

        int id = getID(SelectClientActivity.selected);

        if(id >= 0){
            ContentValues values = new ContentValues();
            values.put(CLIENT_NAME, client.getName());
            values.put(CLIENT_ADDRESS, client.getAddress());
            values.put(CLIENT_CONTACT_INFO, client.getContactInfo());
            values.put(DEALER_FIELD, client.getDealersId());


            db.update(TABLE_CLIENT, values, "_id " + "=" + id, null);
            db.close();
        }

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
                String address = cursor.getString(cursor.getColumnIndex(CLIENT_ADDRESS));
                String contactInfo = cursor.getString(cursor.getColumnIndex(CLIENT_CONTACT_INFO));
                int dealerId = cursor.getInt(cursor.getColumnIndex(DEALER_FIELD));

                if(dealerId==dealersId) {
                    list.add(new Client(id_index, name, address, contactInfo, dealerId));
                }
                cursor.moveToNext();
            }
        }

        cursor.close();
        db.close();

        return list;
    }

    public int getID(Client client){
        int id=-1 ;
        String name = client.getName();
        String address = client.getAddress();
        String contact = client.getContactInfo();
        int dealersId = client.getDealersId();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_CLIENT,null,null,null,null,null,null);

        if(cursor!=null && cursor.getCount()>0) {
            cursor.moveToFirst();
            for(int i=0; i<cursor.getCount();i++)
            {
                int id_index = cursor.getInt(cursor.getColumnIndex(ID));
                String cname = cursor.getString(cursor.getColumnIndex(CLIENT_NAME));
                String caddress = cursor.getString(cursor.getColumnIndex(CLIENT_ADDRESS));
                String ccontact = cursor.getString(cursor.getColumnIndex(CLIENT_CONTACT_INFO));
                int cdealersId = cursor.getInt(cursor.getColumnIndex(DEALER_FIELD));
                if(cname.equals(name) && caddress.equals(address) && ccontact.equals(contact) && cdealersId== dealersId){
                    id = id_index;
                    return id;
                }
                cursor.moveToNext();
            }
        }

        cursor.close();
        db.close();

        return id;
    }


    public void delete(Client client){
        SQLiteDatabase db = this.getWritableDatabase();

        int id = getID(client);

        if (id>=0)
            db.delete(TABLE_CLIENT, "_id " + "=" + id,null);
        db.close();
    }

}
