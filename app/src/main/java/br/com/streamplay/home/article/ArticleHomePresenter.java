package br.com.streamplay.home.article;

import java.util.List;

import br.com.streamplaydomain.Article.ArticleEntity;
import br.com.streamplaydomain.Article.GetArticleHome.ArticlesHomeCallback;
import br.com.streamplaydomain.Article.GetArticleHome.ArticlesHomeInteractor;
import br.com.streamplaydomain.Category.CategoryArticleHome.CategoryArticleHomeCallback;
import br.com.streamplaydomain.Category.CategoryArticleHome.CategoryArticleHomeInteractor;
import br.com.streamplaydomain.Category.CategoryEntity;

public class ArticleHomePresenter implements ArticlesHomeCallback, CategoryArticleHomeCallback{

    ArticleHomePresenterContract.View mCallback;
    ArticlesHomeInteractor mInteractor;
    CategoryArticleHomeInteractor mCategoryInteractor;

    public ArticleHomePresenter(ArticlesHomeInteractor interactor, CategoryArticleHomeInteractor categoryInteractor,
                                ArticleHomePresenterContract.View callback) {
        mInteractor = interactor;
        mCategoryInteractor = categoryInteractor;
        mCallback = callback;
    }

    public void getArticles(){
        mInteractor.getArticles(this);
    }
    public void getCategories(){ mCategoryInteractor.getCategory(this); }

    @Override
    public void onSuccess(List<ArticleEntity> articles) {
        mCallback.onGetArticleSuccess(articles);
    }

    @Override
    public void onCategorySuccess(List<CategoryEntity> categories) {
        mCallback.onGetCategorySuccess(categories);
    }

    @Override
    public void onFailure(Throwable throwable) {
        mCallback.onFailure();
    }
}
