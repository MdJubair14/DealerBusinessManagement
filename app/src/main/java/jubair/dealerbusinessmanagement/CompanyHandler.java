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
public class CompanyHandler  extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "Company Table";

    public static final String TABLE_COMPANY = "company";

    public static final String ID_FIELD = "_id";

    public static final String NAME_FIELD = "name";

    public static final String ADDRESS_FIELD = "address";

    public static final String CONTACT_FIELD = "contact";

    public static final String DEALER_FIELD = "dealerId";

    public String TABLE_COMPANY_SQL = "CREATE TABLE " + TABLE_COMPANY +  "(" + ID_FIELD + " INTEGER PRIMARY KEY, "+ NAME_FIELD +  " TEXT, " + ADDRESS_FIELD +  " TEXT, " + CONTACT_FIELD +  " TEXT, " + DEALER_FIELD +  " INTEGER" + ")";


    public CompanyHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_COMPANY_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMPANY);
        onCreate(db);
    }

    public void insert(Company company){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME_FIELD, company.getName());
        values.put(ADDRESS_FIELD, company.getAddress());
        values.put(CONTACT_FIELD, company.getContactInfo());
        values.put(DEALER_FIELD, company.getCorrespondingDealerId());

        db.insert(TABLE_COMPANY, null, values);
        db.close();
    }

    public void update(Company c){
        SQLiteDatabase db = this.getWritableDatabase();

        int id = getID(SelectCompanyActivity.selected);

        if(id>=0) {
            String name = c.getName();
            String address = c.getAddress();
            String contact = c.getContactInfo();
            int dealersId = c.getCorrespondingDealerId();

            ContentValues values = new ContentValues();

            values.put(NAME_FIELD, name);
            values.put(ADDRESS_FIELD, address);
            values.put(CONTACT_FIELD, contact);
            values.put(DEALER_FIELD, dealersId);


            db.update(TABLE_COMPANY, values, "_id " + "=" + id, null);
            db.close();
        }

    }

    public List<Company> getAllCompanies(int dealersId){
        List<Company> list = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_COMPANY, null, null, null, null, null, null);
        if(cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                int id_index = cursor.getInt(cursor.getColumnIndex(ID_FIELD));
                String name = cursor.getString(cursor.getColumnIndex(NAME_FIELD));
                String address = cursor.getString(cursor.getColumnIndex(ADDRESS_FIELD));
                String contact = cursor.getString(cursor.getColumnIndex(CONTACT_FIELD));
                int dealerId = cursor.getInt(cursor.getColumnIndex(DEALER_FIELD));

                if(dealerId==dealersId) {
                    list.add(new Company(id_index, name, address, contact, dealerId));
                }
                cursor.moveToNext();
            }
        }

        cursor.close();
        db.close();

        return list;
    }

    public int getID(Company company){
        int id=-1 ;
        String name = company.getName();
        String address = company.getAddress();
        String contact = company.getContactInfo();
        int dealersId = company.getCorrespondingDealerId();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_COMPANY,null,null,null,null,null,null);

        if(cursor!=null && cursor.getCount()>0) {
            cursor.moveToFirst();
            for(int i=0; i<cursor.getCount();i++)
            {
                int id_index = cursor.getInt(cursor.getColumnIndex(ID_FIELD));
                String cname = cursor.getString(cursor.getColumnIndex(NAME_FIELD));
                String caddress = cursor.getString(cursor.getColumnIndex(ADDRESS_FIELD));
                String ccontact = cursor.getString(cursor.getColumnIndex(CONTACT_FIELD));
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

    public void delete(Company company){
        SQLiteDatabase db = this.getWritableDatabase();

        int id = getID(company);

        if (id>=0)
            db.delete(TABLE_COMPANY, "_id " + "=" + id,null);
        db.close();
    }
}
