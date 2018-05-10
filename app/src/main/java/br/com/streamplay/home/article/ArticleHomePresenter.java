package br.com.streamplay.home.article;

import java.util.List;

import br.com.streamplay.presenters.ApplicationPresenter;
import br.com.streamplaydomain.article.ArticleEntity;
import br.com.streamplaydomain.article.articlesHome.ArticlesHomeCallback;
import br.com.streamplaydomain.article.articlesHome.ArticlesHomeInteractor;
import br.com.streamplaydomain.base.Executor;
import br.com.streamplaydomain.base.MainThread;

public class ArticleHomePresenter implements ArticlesHomeCallback{

    ArticleHomePresenterContract.View mCallback;
    ArticlesHomeInteractor mInteractor;

    public ArticleHomePresenter(ArticlesHomeInteractor interactor, ArticleHomePresenterContract.View callback) {
        mInteractor = interactor;
        mCallback = callback;
    }

    public void getArticles(){
        mInteractor.getArticles(this);
    }

    @Override
    public void onSuccess(List<ArticleEntity> articles) {
        mCallback.onGetArticleSuccess(articles);
    }

    @Override
    public void onFailure(Throwable throwable) {
        mCallback.onFailure();
    }
}
