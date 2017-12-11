package br.com.streamplay.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Antony on 09/12/2017.
 */

public class HomeData implements Serializable{

    private List<Video> videos;
    private List<Article> articles;

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
