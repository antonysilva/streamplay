package br.com.streamplay.home.article;

import java.util.List;

import br.com.streamplaydomain.article.ArticleEntity;

public interface ArticleHomePresenterContract {

    interface View{
        void onGetArticleSuccess(List<ArticleEntity> articles);
        void onFailure();
    }

}
