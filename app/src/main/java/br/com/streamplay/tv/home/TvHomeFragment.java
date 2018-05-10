package br.com.streamplay.tv.home;

import android.app.LoaderManager;
import android.content.Loader;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v17.leanback.app.BrowseSupportFragment;

import java.util.HashMap;
import java.util.List;

public class TvHomeFragment extends BrowseSupportFragment implements LoaderManager.LoaderCallbacks<HashMap<String, List<Movie>>> {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public Loader<HashMap<String, List<Movie>>> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<HashMap<String, List<Movie>>> loader, HashMap<String, List<Movie>> data) {

    }

    @Override
    public void onLoaderReset(Loader<HashMap<String, List<Movie>>> loader) {

    }
}
