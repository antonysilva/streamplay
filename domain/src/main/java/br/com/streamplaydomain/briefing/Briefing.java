package br.com.streamplaydomain.briefing;

import java.util.List;

import br.com.streamplaydomain.article.Article;
import br.com.streamplaydomain.video.Video;

/**
 * Created by Antony Silva on 07/02/2018.
 */

public class Briefing {

    private List<Video> videos;
    private List<Article> articles;

    public Briefing(List<Video> videos, List<Article> articles) {
        this.videos = videos;
        this.articles = articles;
    }
}
