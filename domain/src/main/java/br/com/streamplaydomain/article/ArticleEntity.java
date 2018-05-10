package br.com.streamplaydomain.article;

import java.io.Serializable;

/**
 * Created by Antony Silva on 07/02/2018.
 */

public class ArticleEntity implements Serializable{

    public int id;
    public String author;
    public String category;
    public String title;
    public String description;
    public String image;
    public String article_url;
    public String published_at;

    public ArticleEntity() {
    }

    public ArticleEntity(int id, String author, String category, String title, String description, String image, String article_url, String published_at) {
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
