package br.com.streamplay.category;

import android.view.View;

import br.com.streamplay.Base.BaseFragment;
import br.com.streamplay.R;

public class CategoryHomeFragment extends BaseFragment{

    private static CategoryHomeFragment instance;

    public static CategoryHomeFragment getInstance() {
        if(instance == null)
            instance = new CategoryHomeFragment();
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
        return R.layout.page_category_home;
    }

    @Override
    public void initializeCompleted() {

    }
}
