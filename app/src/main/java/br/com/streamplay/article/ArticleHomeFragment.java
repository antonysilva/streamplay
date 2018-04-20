package br.com.streamplay.article;

import android.view.View;

import br.com.streamplay.Base.BaseFragment;
import br.com.streamplay.R;

public class ArticleHomeFragment extends BaseFragment {

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
}
