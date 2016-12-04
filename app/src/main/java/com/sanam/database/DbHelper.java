package com.sanam.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by sanam on 12/2/16.
 */

public class DbHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME   = "Kima";
    public static final String UID          = "_id";
    public static final String NAME         = "name";
    public static final String ADDRESS      = "address";
    private static final String DATABASE_NAME = "Pitho";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME
            + " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME + " VARCHAR(255), "
            + ADDRESS + " VARCHAR(255));";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //create table mytable (_id INTEGER PRIMARY KEY AUTOINCREMENT, NAME VARCAR(255));
        /*String query = "CREATE TABLE " + TABLE_NAME + " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255);";*/

        try {
            Log.e("onCreate", "onCreate Called");
            sqLiteDatabase.execSQL(CREATE_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
            Log.e("Sql Exception", e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldversion, int newVersion) {

        Log.e("onUpgrade", "onUpgrade Called");
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);

    }
}
