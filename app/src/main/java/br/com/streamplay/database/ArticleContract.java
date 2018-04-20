package br.com.streamplay.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import br.com.streamplaydomain.entities.Article;

/**
 * Created by Antony on 17/12/2017.
 */

public class ArticleContract {

    public static String[] selectColumns = {
            ArticleEntry.COLUMN_NAME_ID,
            ArticleEntry.COLUMN_NAME_AUTHOR,
            ArticleEntry.COLUMN_NAME_CATEGORY,
            ArticleEntry.COLUMN_NAME_TITLE,
            ArticleEntry.COLUMN_NAME_DESCRIPTION,
            ArticleEntry.COLUMN_NAME_IMAGE,
            ArticleEntry.COLUMN_NAME_ARTICLE_URL,
            ArticleEntry.COLUMN_NAME_PUBLISHED_AT
    };

    public static String whereId = ArticleEntry.COLUMN_NAME_ID + "= ?";
    public static String whereSearchable = "LOWER(" + ArticleEntry.COLUMN_NAME_TITLE + ") LIKE ?";

    public ArticleContract(){

    }

    public static class ArticleEntry implements BaseColumns {
        public static final String TABLE_NAME = "articles";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_AUTHOR = "author";
        public static final String COLUMN_NAME_CATEGORY = "category";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_IMAGE = "image";
        public static final String COLUMN_NAME_ARTICLE_URL = "article_url";
        public static final String COLUMN_NAME_PUBLISHED_AT = "published_at";

        public static final String CREATE_ENTRY = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_NAME_ID + " " + StreamPlayHelper.INTEGER_TYPE + " PRIMARY KEY," +
                COLUMN_NAME_AUTHOR + " " + StreamPlayHelper.TEXT_TYPE + StreamPlayHelper.COMMA_SEP +
                COLUMN_NAME_CATEGORY + " " + StreamPlayHelper.TEXT_TYPE + StreamPlayHelper.COMMA_SEP +
                COLUMN_NAME_TITLE + " " + StreamPlayHelper.TEXT_TYPE + StreamPlayHelper.COMMA_SEP +
                COLUMN_NAME_DESCRIPTION + " " + StreamPlayHelper.TEXT_TYPE + StreamPlayHelper.COMMA_SEP +
                COLUMN_NAME_IMAGE + " " + StreamPlayHelper.TEXT_TYPE + StreamPlayHelper.COMMA_SEP +
                COLUMN_NAME_ARTICLE_URL + " " + StreamPlayHelper.TEXT_TYPE + StreamPlayHelper.COMMA_SEP +
                COLUMN_NAME_PUBLISHED_AT + " " + StreamPlayHelper.TEXT_TYPE + " ); ";
    }

    public static long create(Article article, SQLiteDatabase database) throws Exception{
        ContentValues values = new ContentValues();
        values.put(ArticleEntry.COLUMN_NAME_ID, article.getId());
        values.put(ArticleEntry.COLUMN_NAME_AUTHOR, article.getAuthor());
        values.put(ArticleEntry.COLUMN_NAME_CATEGORY, article.getCategory());
        values.put(ArticleEntry.COLUMN_NAME_TITLE, article.getTitle());
        values.put(ArticleEntry.COLUMN_NAME_DESCRIPTION, article.getDescription());
        values.put(ArticleEntry.COLUMN_NAME_IMAGE, article.getImage());
        values.put(ArticleEntry.COLUMN_NAME_ARTICLE_URL, article.getArticle_url());
        values.put(ArticleEntry.COLUMN_NAME_PUBLISHED_AT, article.getPublished_at());

        long newRowId = database.insert(ArticleEntry.TABLE_NAME, null, values);
        return newRowId;
    }

    public static Cursor find(String[] query, SQLiteDatabase database) throws Exception{
        return database.query(
                ArticleEntry.TABLE_NAME,
                selectColumns,
                whereSearchable,
                query,
                null,
                null,
                null
        );
    }

    public static Cursor findById(String[] id, SQLiteDatabase database) throws Exception{
        return database.query(
                ArticleEntry.TABLE_NAME,
                selectColumns,
                whereId,
                id,
                null,
                null,
                null
        );
    }
}
