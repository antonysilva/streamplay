package br.com.streamplaydata.article.api.callbacks;

import java.util.List;

import br.com.streamplaydomain.article.ArticleEntity;

public interface GetAllArticleCallback {

    void onSuccess(List<ArticleEntity> articleEntities);
    void onError();

}
