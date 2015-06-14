package jubair.dealerbusinessmanagement;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 6/12/2015.
 */
public class ItemHandler  extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "Item Table";

    public static final String TABLE_ITEM = "item";

    public static final String ID_FIELD = "_id";

    public static final String NAME_FIELD = "name";

    public static final String PRICE_FIELD = "price";

    public static final String QUANTITY_FIELD = "quantity";

    public static final String PERCENTAGE_FIELD = "percentage";

    public static final String DEALER_FIELD = "dealerId";

    public String TABLE_ITEM_SQL = "CREATE TABLE " + TABLE_ITEM +  "(" + ID_FIELD + " INTEGER PRIMARY KEY, "+ NAME_FIELD +  " TEXT, " + PRICE_FIELD +  " TEXT, " + QUANTITY_FIELD +  " TEXT, " +  PERCENTAGE_FIELD + " TEXT, " + DEALER_FIELD +  " INTEGER" + ")";


    public ItemHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_ITEM_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEM);
        onCreate(db);
    }

    public void insert(Item item){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ID_FIELD, item.getId());
        values.put(NAME_FIELD, item.getName());
        values.put(PRICE_FIELD, String.valueOf(item.getPrice()));
        values.put(QUANTITY_FIELD, String.valueOf(item.getQuantity()));
        values.put(PERCENTAGE_FIELD, String.valueOf(item.getPercentage()));
        values.put(DEALER_FIELD, item.getDealerId());

        db.insert(TABLE_ITEM, null, values);
        db.close();
    }

    public void update(Item item){
        SQLiteDatabase db = this.getWritableDatabase();

        int id = getID(SelectItemActivity.selected);

        if(id>=0) {
            String name = item.getName();
            String price = String.valueOf(item.getPrice());
            String quantity = String.valueOf(item.getQuantity());
            String percentage = String.valueOf(item.getPercentage());
            int dealersId = item.getDealerId();

            ContentValues values = new ContentValues();

            values.put(NAME_FIELD, name);
            values.put(PRICE_FIELD, price);
            values.put(QUANTITY_FIELD, quantity);
            values.put(PERCENTAGE_FIELD, percentage);
            values.put(DEALER_FIELD, dealersId);


            db.update(TABLE_ITEM, values, "_id " + "=" + id, null);
            db.close();
        }

    }

    public List<Item> getAllItems(int dealersId){
        List<Item> list = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_ITEM, null, null, null, null, null, null);
        if(cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                int id_index = cursor.getInt(cursor.getColumnIndex(ID_FIELD));
                String name = cursor.getString(cursor.getColumnIndex(NAME_FIELD));
                String price = cursor.getString(cursor.getColumnIndex(PRICE_FIELD));
                String quantity = cursor.getString(cursor.getColumnIndex(QUANTITY_FIELD));
                String percentage = cursor.getString(cursor.getColumnIndex(PERCENTAGE_FIELD));
                int dealerId = cursor.getInt(cursor.getColumnIndex(DEALER_FIELD));

                if(dealerId==dealersId) {
                    list.add(new Item(id_index, name, Double.parseDouble(price), Double.parseDouble(quantity), Double.parseDouble(percentage), dealerId));
                }
                cursor.moveToNext();
            }
        }

        cursor.close();
        db.close();

        return list;
    }

    public int getID(Item item){
        int id=-1 ;
        String name = item.getName();
        String price = String.valueOf(item.getPrice());
        String quantty = String.valueOf(item.getQuantity());
        String percetage = String.valueOf(item.getPercentage());
        int dealersId = item.getDealerId();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_ITEM,null,null,null,null,null,null);

        if(cursor!=null && cursor.getCount()>0) {
            cursor.moveToFirst();
            for(int i=0; i<cursor.getCount();i++)
            {
                int id_index = cursor.getInt(cursor.getColumnIndex(ID_FIELD));
                String cname = cursor.getString(cursor.getColumnIndex(NAME_FIELD));
                String cprice = cursor.getString(cursor.getColumnIndex(PRICE_FIELD));
                String cquantity = cursor.getString(cursor.getColumnIndex(QUANTITY_FIELD));
                String cpercentage = cursor.getString(cursor.getColumnIndex(PERCENTAGE_FIELD));
                int cdealerId = cursor.getInt(cursor.getColumnIndex(DEALER_FIELD));

                if(cname.equals(name) && cprice.equals(price) && cquantity.equals(quantty) && cpercentage.equals(percetage) && cdealerId== dealersId){
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

    public void delete(Item item){
        SQLiteDatabase db = this.getWritableDatabase();

        int id = getID(item);

        if (id>=0)
            db.delete(TABLE_ITEM, "_id " + "=" + id,null);
        db.close();
    }
}
