package com.example.satish.xchange;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

/**
 * Created by SATISH on 2/22/2016.
 */
public class DatabaseHelp extends SQLiteOpenHelper {
    private static final String TAG = DatabaseHelp.class.getSimpleName();

    public static final String DATABASE_NAME = "Xchange.db";
    public static final String TABLE_NAME1 = "Lended";
    public static final String TABLE_NAME2 = "Borrowed";

    public static final String T1_COL1 = "Borrower";
    public static final String T1_COL2 = "Item";
    public static final String T1_COL3 = "Type";

    public static final String T2_COL1 = "Lender";
    public static final String T2_COL2 = "Item";
    public static final String T2_COL3 = "Type";

    public DatabaseHelp(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME1 + " (Borrower TEXT,Item TEXT,Type TEXT)");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(db);

    }

    public boolean insertData(String name , String item , String item_type)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(T1_COL1,name);
        contentValues.put(T1_COL2,item);
        contentValues.put(T1_COL3, item_type);

        long result = db.insert(TABLE_NAME1 , null , contentValues);

        if(result == -1)
            return false;

        else
            return true;
    }

    public Cursor getAllLended()
    {
        String qry = "SELECT * FROM " + TABLE_NAME1;
        Log.d(TAG , "getAllLended()" + qry);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery(qry , null);
        return res;
    }


    public boolean updateData(String name , String item , String item_type)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(T1_COL1,name);
        contentValues.put(T1_COL2,item);
        contentValues.put(T1_COL3, item_type);

        db.update(TABLE_NAME1 , contentValues , "Item = ?" , new String[] {item});
        return true;
    }

    public boolean DeleteLended(String name , String item , String type)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(TABLE_NAME1 , "Borrower = ? and Item = ? and Type = ?" , new String[] {name , item , type}) > 0;

    }
}
