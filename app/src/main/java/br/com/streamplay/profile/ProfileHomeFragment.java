package br.com.streamplay.profile;

import android.view.View;

import br.com.streamplay.Base.BaseFragment;
import br.com.streamplay.R;

public class ProfileHomeFragment extends BaseFragment {

    private static ProfileHomeFragment instance;

    public static ProfileHomeFragment getInstance() {
        if(instance == null)
            instance = new ProfileHomeFragment();
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
        return R.layout.page_profile_home;
    }

    @Override
    public void initializeCompleted() {

    }
}
