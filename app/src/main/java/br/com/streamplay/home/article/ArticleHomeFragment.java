package br.com.streamplay.home.article;

import android.view.View;

import java.util.List;

import br.com.streamplay.Base.BaseFragment;
import br.com.streamplay.R;
import br.com.streamplay.article.presenter.ArticleHomePresenter;
import br.com.streamplaydomain.article.ArticleEntity;
import br.com.streamplaydomain.article.articlesHome.ArticlesHomeInteractor;
import br.com.streamplaydomain.entities.Category;

public class ArticleHomeFragment extends BaseFragment implements ArticleHomePresenter.View {

    private static ArticleHomeFragment instance;

    public static ArticleHomeFragment getInstance() {
        if(instance == null)
            instance = new ArticleHomeFragment();
        return instance;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void initView(View view) {

    }

    @Override
    public int layoutId() {
        return R.layout.page_article_home;
    }

    @Override
    public void initializeCompleted() {

    }

    @Override
    public void onGetAllCategorySuccess(List<Category> categories) {
        
    }

    @Override
    public void onGetAllArticleSuccess(List<ArticleEntity> articleEntities) {

    }
}
