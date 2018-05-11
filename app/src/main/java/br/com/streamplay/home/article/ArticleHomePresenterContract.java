package br.com.streamplay.home.article;

import java.util.List;

import br.com.streamplaydomain.Article.ArticleEntity;
import br.com.streamplaydomain.Category.CategoryEntity;

public interface ArticleHomePresenterContract {

    interface View{
        void onGetArticleSuccess(List<ArticleEntity> articles);
        void onGetCategorySuccess(List<CategoryEntity> categories);
        void onFailure();
    }

}
