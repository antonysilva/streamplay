package br.com.streamplay.favorite;

import android.view.View;

import br.com.streamplay.Base.BaseFragment;
import br.com.streamplay.R;

public class FavoriteHomeFragment extends BaseFragment{

    private static FavoriteHomeFragment instance;

    public static FavoriteHomeFragment getInstance() {
        if(instance == null)
            instance = new FavoriteHomeFragment();
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
        return R.layout.page_favorite_home;
    }

    @Override
    public void initializeCompleted() {

    }
}
