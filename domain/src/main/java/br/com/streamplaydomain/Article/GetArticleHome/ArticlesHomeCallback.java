package br.com.streamplaydomain.Article.GetArticleHome;

import java.util.List;

import br.com.streamplaydomain.Article.ArticleEntity;

public interface ArticlesHomeCallback {

    void onSuccess(List<ArticleEntity> articles);
    void onFailure(Throwable throwable);

}
