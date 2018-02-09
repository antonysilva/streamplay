package br.com.streamplay.adapters;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import br.com.streamplay.Constant;
import br.com.streamplay.ui.home.HomePagerFragment;
import br.com.streamplaydomain.briefing.model.Briefing;

/**
 * Created by Antony on 08/12/2017.
 */

public class HomeViewPagerAdapter extends FragmentStatePagerAdapter {

    String[] mPagerTitle = {"Vídeo", "Artigo"};
    Briefing mHomeData;

    public HomeViewPagerAdapter(FragmentManager fm, Briefing homeData) {
        super(fm);
        mHomeData = homeData;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle args = new Bundle();

        HomePagerFragment fragment = new HomePagerFragment();

        args.putSerializable(Constant.BUNDLE_HOME_DATA, mHomeData);
        args.putInt(Constant.BUNDLE_PAGER_POSITION, position);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public int getCount() {
        return mPagerTitle.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mPagerTitle[position];
    }
}
