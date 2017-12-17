package br.com.streamplay.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import br.com.streamplay.models.Video;

/**
 * Created by Antony on 17/12/2017.
 */

public class VideoContract {

    public VideoContract(){}

    public static class VideoEntry implements BaseColumns {
        public static final String TABLE_NAME = "videos";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_CATEGORY = "category";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_IMAGE_URL = "image_url";
        public static final String COLUMN_NAME_VIDEO_URL = "video_url";
        public static final String COLUMN_NAME_TAGS = "tags";

        public static final String CREATE_ENTRY = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_NAME_ID + " " + StreamPlayHelper.INTEGER_TYPE + " PRIMARY KEY," +
                COLUMN_NAME_TITLE + " " + StreamPlayHelper.TEXT_TYPE + StreamPlayHelper.COMMA_SEP +
                COLUMN_NAME_CATEGORY + " " + StreamPlayHelper.TEXT_TYPE + StreamPlayHelper.COMMA_SEP +
                COLUMN_NAME_DESCRIPTION + " " + StreamPlayHelper.TEXT_TYPE + StreamPlayHelper.COMMA_SEP +
                COLUMN_NAME_IMAGE_URL + " " + StreamPlayHelper.TEXT_TYPE + StreamPlayHelper.COMMA_SEP +
                COLUMN_NAME_VIDEO_URL + " " + StreamPlayHelper.TEXT_TYPE + StreamPlayHelper.COMMA_SEP +
                COLUMN_NAME_TAGS + " " + StreamPlayHelper.TEXT_TYPE + " ); ";
    }

    public static long create(Video video, SQLiteDatabase database) throws Exception{
        ContentValues values = new ContentValues();
        values.put(VideoEntry.COLUMN_NAME_ID, 1);
        values.put(VideoEntry.COLUMN_NAME_TITLE, video.getTitle());
        values.put(VideoEntry.COLUMN_NAME_CATEGORY, video.getCategory());
        values.put(VideoEntry.COLUMN_NAME_DESCRIPTION, video.getDescription());
        values.put(VideoEntry.COLUMN_NAME_IMAGE_URL, video.getImageUrl());
        values.put(VideoEntry.COLUMN_NAME_VIDEO_URL, video.getVideoUrl());

        long newRowId = database.insert(VideoEntry.TABLE_NAME, null, values);
        return newRowId;
    }
}
