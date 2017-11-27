package com.example.rohit.studentdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NotesDatabase extends SQLiteOpenHelper {

    static final String dbName="notes.db";
    static final String tableName="notes";
    static final String columnName="name";
    static final  String columnDiscription="discription";
    static final  String createQuery="create table notes(name text,discription text)";
    public NotesDatabase(Context context) {
        super(context, dbName, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long insertNote(Notes notes){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(columnName,notes.getName());
        contentValues.put(columnDiscription,notes.getDiscription());
        long id=sqLiteDatabase.insert(tableName,null,contentValues);

        return id;
    }
}
