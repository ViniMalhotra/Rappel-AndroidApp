package com.example.vini2.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by vini on 16-03-2017
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1= "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SURNAME";
    public static final String COL_4 = "MARKS";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME,null,2);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT,SURNAME TEXT,MARKS INTEGER )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABBLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String name, String surname, String marks){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, surname);
        contentValues.put(COL_4, marks);
        long result = db.insert(TABLE_NAME,null, contentValues);
        if(result == -1)
            return false;
        else
            return true;

    }
  /*  public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
       // Cursor res = db.rawQuery("select * from" +TABLE_NAME, null);
        //return res;
        return db.rawQuery("select * from" +TABLE_NAME, null);

    }*/
    public String databaseToString()
    {
        String dbString = "a";
       SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        //cursor will point to a location in your results
        Cursor c = db.rawQuery(query,null);
        Log.d("myTag","in databaseToString");
        c.moveToFirst();
        try {
            int i=0;
           // while (!c.isAfterLast()) {
            while(c.moveToNext()){
              //  if (c.getString(c.getColumnIndex(COL_1)) != null) {
                    Log.d("myTag1", "in databaseToString while loop");
                    //dbString += c.getString(c.getColumnIndex(COL_2));
                     c.moveToNext();
                    dbString += c.getString(c.getColumnIndex(COL_2));
                    i++;
                    dbString += "\n";
               // }
            }
        }
        finally {
            db.close();
            c.close();
        }

        return dbString;
    }

}
