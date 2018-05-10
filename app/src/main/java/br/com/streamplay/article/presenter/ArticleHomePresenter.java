package br.com.streamplay.article.presenter;

import java.util.List;

import br.com.streamplaydomain.article.ArticleEntity;
import br.com.streamplaydomain.entities.Category;

public interface ArticleHomePresenter {

    void getAllCategory();
    void getAllArticle(String category);
    void resume();
    void pause();
    void stop();

    interface View{
        void onGetAllCategorySuccess(List<Category> categories);
        void onGetAllArticleSuccess(List<ArticleEntity> articleEntities);
    }

}
