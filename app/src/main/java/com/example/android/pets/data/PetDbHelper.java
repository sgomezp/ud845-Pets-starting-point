package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.pets.data.PetsContract.PetsEntry;

/**
 * Created by sgomezp on 01/07/2017.
 */

public class PetDbHelper extends SQLiteOpenHelper {

    public static final  int DATABASE_VERSION = 1;
    public static final  String DATABASE_NAME = "shelter.db";

    // Constructor
    public PetDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){

         final String SQL_CREATE_PETS_TABLE = "CREATE TABLE " + PetsEntry.TABLE_NAME +
                " (" + PetsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PetsEntry.COLUMN_PET_NAME + " TEXT NOT NULL, " +
                PetsEntry.COLUMN_PET_BREED + " TEXT, " +
                PetsEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL, " +
                PetsEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";


        // execute the SQL statement
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXIST " + PetsEntry.TABLE_NAME;

        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
