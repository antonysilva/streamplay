package br.com.streamplaydomain.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.streamplaydomain.article.ArticleEntity;
import br.com.streamplaydomain.video.VideoEntity;


/**
 * Created by Antony Silva on 07/02/2018.
 */

public class Briefing implements Serializable{

    private List<VideoEntity> videos;
    private List<ArticleEntity> articleEntities;

    public Briefing(){
        videos = new ArrayList<>();
        articleEntities = new ArrayList<>();
    }

    public Briefing(List<VideoEntity> videos, List<ArticleEntity> articleEntities) {
        this.videos = videos;
        this.articleEntities = articleEntities;
    }

    public List<VideoEntity> getVideos() {
        return videos;
    }

    public void setVideos(List<VideoEntity> videos) {
        this.videos = videos;
    }

    public List<ArticleEntity> getArticleEntities() {
        return articleEntities;
    }

    public void setArticleEntities(List<ArticleEntity> articleEntities) {
        this.articleEntities = articleEntities;
    }
}
