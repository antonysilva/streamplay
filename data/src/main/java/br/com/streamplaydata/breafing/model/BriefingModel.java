package br.com.streamplaydata.breafing.model;

import com.google.gson.annotations.SerializedName;

import br.com.streamplaydata.article.model.ArticleModel;
import br.com.streamplaydata.video.model.VideoModel;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public class BriefingModel {

    @SerializedName("videoModels")
    private VideoModel[] videoModels;
    @SerializedName("articleModels")
    private ArticleModel[] articleModels;

    public VideoModel[] getVideoModels() {
        return videoModels;
    }

    public void setVideoModels(VideoModel[] videoModels) {
        this.videoModels = videoModels;
    }

    public ArticleModel[] getArticleModels() {
        return articleModels;
    }

    public void setArticleModels(ArticleModel[] articleModels) {
        this.articleModels = articleModels;
    }
}
