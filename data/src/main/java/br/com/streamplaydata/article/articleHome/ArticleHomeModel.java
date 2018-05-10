package br.com.streamplaydata.article.articleHome;

import com.google.gson.annotations.SerializedName;

public class ArticleHomeModel {

    @SerializedName("id")
    public int id;
    @SerializedName("author")
    public String author;
    @SerializedName("category")
    public String category;
    @SerializedName("title")
    public String title;
    @SerializedName("description")
    public String description;
    @SerializedName("image")
    public String image;
    @SerializedName("article_url")
    public String article_url;
    @SerializedName("published_at")
    public String published_at;

    public ArticleHomeModel() {
    }

    public ArticleHomeModel(int id, String author, String category, String title, String description, String image, String article_url, String published_at) {
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
