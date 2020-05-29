package com.example.android.store.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StoreDbHelper extends SQLiteOpenHelper {
    public static final String LOG_TAG = StoreDbHelper.class.getSimpleName();
    /** Name of the database file */
    private static final String DATABASE_NAME = "inventory.db";
    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 4;
    /**
     * Constructs a new instance of {@link StoreDbHelper}.
     *
     * @param context of the app
     */
    public StoreDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_PETS_TABLE =  "CREATE TABLE " + StoreContact.StoreEntry.TABLE_NAME + " ("
                + StoreContact.StoreEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + StoreContact.StoreEntry.COLUMN_PRODUCT_NAME + " TEXT NOT NULL, "
                + StoreContact.StoreEntry.COLUMN_QUANTITY + " INTEGER, "
                + StoreContact.StoreEntry.COLUMN_PRICE + " REAL NOT NULL, "
                + StoreContact.StoreEntry.COLUMN_SUPPLIER_NAME + " TEXT NOT NULL, "
                + StoreContact.StoreEntry.COLUMN_SUPPLIER_PHONE_NUMBER + " TEXT NOT NULL);";
        // Execute the SQL statement
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }
    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + StoreContact.StoreEntry.TABLE_NAME);
        onCreate(db);
    }
}