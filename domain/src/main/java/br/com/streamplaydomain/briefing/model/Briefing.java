package br.com.streamplaydomain.briefing.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.streamplaydomain.article.Article;
import br.com.streamplaydomain.video.Video;

/**
 * Created by Antony Silva on 07/02/2018.
 */

public class Briefing implements Serializable{

    private List<Video> videos;
    private List<Article> articles;

    public Briefing(){
        videos = new ArrayList<>();
        articles = new ArrayList<>();
    }

    public Briefing(List<Video> videos, List<Article> articles) {
        this.videos = videos;
        this.articles = articles;
    }

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
