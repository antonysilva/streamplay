package br.com.streamplaydata.article.articleHome.api;

import java.util.List;

import br.com.streamplaydata.article.articleHome.ArticleHomeModel;
import br.com.streamplaydomain.video.VideoEntity;

public interface ArticlesHomeClientCallback {

    void onSuccess(List<ArticleHomeModel> articles);
    void onFailure(Throwable throwable);
}
