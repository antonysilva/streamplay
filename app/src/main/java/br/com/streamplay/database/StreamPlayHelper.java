package br.com.streamplay.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Antony on 17/12/2017.
 */

public class StreamPlayHelper extends SQLiteOpenHelper{

    public static final int DB_VERSION = 3;
    public static final String DB_NAME = "StreamPlay.db";

    public static final String TEXT_TYPE = " TEXT";
    public static final String INTEGER_TYPE = " INTEGER";
    public static final String COMMA_SEP = ",";

    public static final String[] SQL_DELETE_ENTRIES = {
            "DROP TABLE IF EXISTS " + VideoContract.VideoEntry.TABLE_NAME,
            "DROP TABLE IF EXISTS " + ArticleContract.ArticleEntry.TABLE_NAME,
            "DROP TABLE IF EXISTS " + FavoriteContract.FavoriteEntry.TABLE_NAME
    };


    public StreamPlayHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(VideoContract.VideoEntry.CREATE_ENTRY);
        sqLiteDatabase.execSQL(ArticleContract.ArticleEntry.CREATE_ENTRY);
        sqLiteDatabase.execSQL(FavoriteContract.FavoriteEntry.CREATE_ENTRY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES[0]);
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES[1]);
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES[2]);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}
