package br.com.streamplay.models;

import java.io.Serializable;

/**
 * Created by Antony on 09/12/2017.
 */

public class Article implements Serializable{

    private String author;
    private String category;
    private String title;
    private String description;
    private String image;
    private String article_url;
    private String published_at;

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

    public String getShortTitle() {
        if (title.length() > 60)
            return title.substring(0,59) + "...";
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        if (description.length() > 150)
            return description.substring(0,149) + "...";
        return description;
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
