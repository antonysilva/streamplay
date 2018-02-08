package br.com.streamplaydata.breafing.model;

import java.util.List;

import br.com.streamplaydata.article.model.Article;
import br.com.streamplaydata.video.model.Video;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public class Briefing {

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
