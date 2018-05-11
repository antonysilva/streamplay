package br.com.streamplaydata.article.articlehome.api;

import java.util.List;

import br.com.streamplaydata.article.articlehome.ArticleHomeModel;

public interface ArticlesHomeClientCallback {

    void onSuccess(List<ArticleHomeModel> articles);
    void onFailure(Throwable throwable);
}
