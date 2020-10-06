package data.access;

import java.sql.SQLException;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;

import androidx.room.Database;

public class DBManager {

    private DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String name, String numberOfGold, String numberOfWin, String numberOfLose, String numberOfStar) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.USER_NAME, name);
        contentValue.put(DatabaseHelper.NUMBER_OF_GOLD, numberOfGold);
        contentValue.put(DatabaseHelper.NUMBER_OF_WIN, numberOfWin);
        contentValue.put(DatabaseHelper.NUMBER_OF_LOSE, numberOfLose);
        contentValue.put(DatabaseHelper.NUMBER_OF_STAR, numberOfStar);
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[] { DatabaseHelper._ID, DatabaseHelper.USER_NAME, DatabaseHelper.NUMBER_OF_GOLD };
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String name, String numberOfGold, String numberOfWin, String numberOfLose, String numberOfStar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.USER_NAME, name);
        contentValues.put(DatabaseHelper.NUMBER_OF_GOLD, numberOfGold);
        contentValues.put(DatabaseHelper.NUMBER_OF_WIN, numberOfWin);
        contentValues.put(DatabaseHelper.NUMBER_OF_LOSE, numberOfLose);
        contentValues.put(DatabaseHelper.NUMBER_OF_STAR,numberOfStar);
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);
    }
    public void clearDB(){
        Cursor cursor = this.fetch();
        while (cursor != null){
            delete(0);
        }
    }

}
