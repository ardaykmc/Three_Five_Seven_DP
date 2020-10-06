package data.access;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Table Name
    public static final String TABLE_NAME = "USER_INFO";

    // Table columns
    public static final String _ID = "_id";
    public static final String USER_NAME = "user_name";
    public static final String NUMBER_OF_GOLD = "number_of_gold";
    public static final String NUMBER_OF_WIN = "number_of_win";
    public static final String NUMBER_OF_LOSE = "number_of_lose";
    public static final String NUMBER_OF_STAR = "number_of_star";
    // Database Information
    static final String DB_NAME = "GAME.DB";

    // database version
    static final int DB_VERSION = 1;

    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + USER_NAME + " TEXT NOT NULL, " + NUMBER_OF_GOLD + " TEXT, " + NUMBER_OF_WIN +" TEXT, " + NUMBER_OF_LOSE + " TEXT, " + NUMBER_OF_STAR +" TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


}
