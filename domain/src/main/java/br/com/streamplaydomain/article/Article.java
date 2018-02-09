package br.com.streamplaydomain.article;

import java.io.Serializable;

/**
 * Created by Antony Silva on 07/02/2018.
 */

public class Article implements Serializable{

    private int id;
    private String author;
    private String category;
    private String title;
    private String description;
    private String image;
    private String article_url;
    private String published_at;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getArticle_url() {
        return article_url;
    }

    public void setArticle_url(String article_url) {
        this.article_url = article_url;
    }

    public String getPublished_at() {
        return published_at;
    }

    public void setPublished_at(String published_at) {
        this.published_at = published_at;
    }
}
