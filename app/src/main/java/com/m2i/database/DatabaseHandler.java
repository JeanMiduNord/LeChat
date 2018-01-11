package com.m2i.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "chat_database";
    private static final int DATABASE_VERSION = 1;

    private static final String CONTACT_TABLE_SQL = "create table tache (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "tache TEXT," +
            "done INTEGER)";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CONTACT_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tache");
        this.onCreate(sqLiteDatabase);
    }
}