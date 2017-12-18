package br.com.streamplay.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import br.com.streamplay.models.Video;

/**
 * Created by Antony on 17/12/2017.
 */

public class VideoContract {

    public static String[] selectColumns = {
        VideoEntry.COLUMN_NAME_ID,
        VideoEntry.COLUMN_NAME_TITLE,
        VideoEntry.COLUMN_NAME_CATEGORY,
        VideoEntry.COLUMN_NAME_DESCRIPTION,
        VideoEntry.COLUMN_NAME_IMAGE_URL,
        VideoEntry.COLUMN_NAME_VIDEO_URL,
        VideoEntry.COLUMN_NAME_TAGS
    };

    public static String whereId = VideoEntry.COLUMN_NAME_ID + "= ?";
    public static String whereSearchable = "LOWER(" + VideoEntry.COLUMN_NAME_TITLE + ") LIKE ?";

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
        values.put(VideoEntry.COLUMN_NAME_ID, video.getId());
        values.put(VideoEntry.COLUMN_NAME_TITLE, video.getTitle());
        values.put(VideoEntry.COLUMN_NAME_CATEGORY, video.getCategory());
        values.put(VideoEntry.COLUMN_NAME_DESCRIPTION, video.getDescription());
        values.put(VideoEntry.COLUMN_NAME_IMAGE_URL, video.getImageUrl());
        values.put(VideoEntry.COLUMN_NAME_VIDEO_URL, video.getVideoUrl());

        long newRowId = database.insert(VideoEntry.TABLE_NAME, null, values);
        return newRowId;
    }

    public static Cursor find(String[] query, SQLiteDatabase database) throws Exception{
        return database.query(
            VideoEntry.TABLE_NAME,
            VideoContract.selectColumns,
            VideoContract.whereSearchable,
            query,
            null,
            null,
            null
        );
    }

    public static Cursor findById(String[] id, SQLiteDatabase database) throws Exception{
        return database.query(
                VideoEntry.TABLE_NAME,
                VideoContract.selectColumns,
                VideoContract.whereId,
                id,
                null,
                null,
                null
        );
    }
}
