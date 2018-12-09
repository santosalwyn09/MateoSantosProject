package com.mateo.andrea.projectmateosantos.com.logics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME="EDMTDev";
    private static final int DB_VER = 1;
    private static final String DB_TABLE="Log";
    private static final String DB_COLUMN="LogContent";

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VER);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = String.format("CREATE TABLE %s (ID INTEGER PRIMARY KEY AUTOINCREMENT,%s TEXT NOT NULL)",DB_TABLE, DB_COLUMN);
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = String.format("DELETE TABLE IF EXISTS %s",DB_TABLE);
        db.execSQL(query);
        onCreate(db);

    }

    public void InsertNewLog (String lg){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DB_COLUMN, lg);
        db.insertWithOnConflict(DB_TABLE,null,values,SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }

    public void deletelgs (String lg){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DB_TABLE,DB_COLUMN + " = ?", new String[]{lg});
        db.close();
    }

    public ArrayList<String> getLogsList(){
            ArrayList<String> logslist = new ArrayList<>();
            SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =  db.query(DB_TABLE, new String[]{DB_COLUMN},null, null,null, null, null);
        while (cursor.moveToNext()){
            int index = cursor.getColumnIndex(DB_COLUMN);
            logslist.add(cursor.getString(index));
        }
        cursor.close();
        db.close();
        return logslist;
    }
}
