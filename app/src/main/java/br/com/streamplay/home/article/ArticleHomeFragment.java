package br.com.streamplay.home.article;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import br.com.streamplay.Base.BaseFragment;
import br.com.streamplay.R;
import br.com.streamplaydomain.Article.ArticleEntity;
import br.com.streamplaydomain.Category.CategoryEntity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleHomeFragment extends BaseFragment implements ArticleHomePresenterContract.View {

    private static ArticleHomeFragment instance;
    @BindView(R.id.list_articles)
    RecyclerView mRecyclerViewArticle;
    @BindView(R.id.list_category)
    RecyclerView mRecyclerViewCategory;
    Context mContext;
    ArticleHomePresenter mPresenter;

    public static ArticleHomeFragment getInstance() {
        if(instance == null)
            instance = new ArticleHomeFragment();
        return instance;
    }

    @Override
    public void initialize() {
        mContext = getContext();
        mPresenter = new ArticleHomePresenter(ArticleHomeInteractorBuilder.create(), CategoryArticleHomeInteractorBuilder.create(), this);
    }

    @Override
    public void initView(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public int layoutId() {
        return R.layout.page_article_home;
    }

    @Override
    public void initializeCompleted() {
        LinearLayoutManager llm = new LinearLayoutManager(mContext);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerViewArticle.setLayoutManager(llm);

        LinearLayoutManager llm2 = new LinearLayoutManager(mContext);
        llm2.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerViewCategory.setLayoutManager(llm2);

        mPresenter.getArticles();
        mPresenter.getCategories();
    }

    @Override
    public void onGetArticleSuccess(List<ArticleEntity> articles) {
        mRecyclerViewArticle.setAdapter(new ArticleHomeRecyclerViewAdapter(mContext, articles));
    }

    @Override
    public void onGetCategorySuccess(List<CategoryEntity> categories) {
        mRecyclerViewCategory.setAdapter(new CategoryArticleHomeRecyclerViewAdapter(mContext, categories));
    }

    @Override
    public void onFailure() {

    }
}
