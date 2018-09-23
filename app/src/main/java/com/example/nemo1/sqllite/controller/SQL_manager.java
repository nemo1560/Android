package com.example.nemo1.sqllite.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.nemo1.sqllite.model.eStudent;

import java.util.ArrayList;
import java.util.List;

public class SQL_manager extends SQLiteOpenHelper {
    private final static int DATABASE_VERSION = 1;
    private final static String DATABASE_NAME = "db_Student_Manager";
    private final static String DATABASE_TABLE = "infoStudent";
    private static final String ID = "ID";
    private static final String TEN = "TEN";
    private static final String LOP = "LOP";
    private static final String MON = "MON";
    private Cursor cursor;

    public SQL_manager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQuery = "CREATE TABLE "+DATABASE_TABLE +" (" +
                ID +" integer primary key, "+
                TEN + " TEXT, "+
                LOP +" TEXT, "+
                MON+" TEXT )";
        db.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        // Create tables again
        onCreate(db);
    }

    /*
    *
    * All CRUD Operation
    *
    * */

    public void insertData(eStudent eStudent){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(TEN,eStudent.getSv_Ten());
        contentValues.put(LOP,eStudent.getSv_Lop());
        contentValues.put(MON,eStudent.getSv_Mon());

        // Inserting Row
        sqLiteDatabase.insert(DATABASE_TABLE,null,contentValues);
        sqLiteDatabase.close();
        Log.d("Test","OKd");
    }

    public boolean login(String name_Std, String class_Std){
        boolean check = false;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String selection = TEN +" =?" +" and "+ LOP +" =?";
        String[] selectionArgs = new String[]{name_Std,class_Std};
        cursor = sqLiteDatabase.query(DATABASE_TABLE,new String[]{TEN,LOP},selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        if(count > 0){
            check = true;
            cursor.close();
            return check;
        }
        else {
            check = false;
            cursor.close();
            return check;
        }
    }

    public List<eStudent>getAll(){
        List<eStudent>eStudentList = new ArrayList<>();
        String query = " SELECT * FROM " + DATABASE_TABLE;
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        cursor = sqLiteDatabase.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                eStudent eStudent = new eStudent(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3));
                eStudentList.add(eStudent);
            }while (cursor.moveToNext());
        }
        return eStudentList;
    }

    public List<eStudent>getRequest(String name){
        List<eStudent>eStudentList = new ArrayList<>();
        String selection_TEN = TEN+" =?";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        if(!name.equals("")) {
            cursor = sqLiteDatabase.query(DATABASE_TABLE, null, selection_TEN, new String[]{name}, null, null, null);
            if(cursor.moveToFirst()) {
                do {
                    eStudent eStudent = new eStudent(0, null, cursor.getString(0), null);
                    eStudentList.add(eStudent);
                } while (cursor.moveToNext());
            }
        }
        return eStudentList;
    }

}
