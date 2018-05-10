package br.com.streamplaydomain.article.articlesHome;

import java.util.List;

import br.com.streamplaydomain.article.ArticleEntity;

public interface ArticlesHomeCallback {

    void onSuccess(List<ArticleEntity> articles);
    void onFailure(Throwable throwable);

}
