package br.com.streamplaydomain.article;

/**
 * Created by Antony Silva on 07/02/2018.
 */

public class Article {

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


}
