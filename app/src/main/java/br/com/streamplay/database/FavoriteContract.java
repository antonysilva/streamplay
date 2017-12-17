package br.com.streamplay.database;

import android.provider.BaseColumns;

/**
 * Created by Antony on 17/12/2017.
 */

public class FavoriteContract {

    public FavoriteContract(){}

    public static class FavoriteEntry implements BaseColumns{
        public static final String TABLE_NAME = "favorite";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_TYPE = "type";
        public static final String COLUMN_NAME_RATING = "rating";

        public static final String CREATE_ENTRY = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_NAME_ID + " " + StreamPlayHelper.INTEGER_TYPE + " PRIMARY KEY," +
                COLUMN_NAME_RATING + " " + StreamPlayHelper.TEXT_TYPE + StreamPlayHelper.COMMA_SEP +
                COLUMN_NAME_TYPE + " " + StreamPlayHelper.TEXT_TYPE + " ); ";
    }



}
