package br.com.streamplaydata.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Antony Silva on 07/02/2018.
 */

public class Article {

    @SerializedName("id")
    int id;
    @SerializedName("author")
    String author;
    @SerializedName("category")
    String category;
    @SerializedName("title")
    String title;
    @SerializedName("description")
    String description;
    @SerializedName("image")
    String image;
    @SerializedName("article_url")
    String article_url;
    @SerializedName("published_at")
    String published_at;

    public Article() {
    }

    public Article(int id, String author, String category, String title, String description, String image, String article_url, String published_at) {
        this.id = id;
        this.author = author;
        this.category = category;
        this.title = title;
        this.description = description;
        this.image = image;
        this.article_url = article_url;
        this.published_at = published_at;
    }


}
