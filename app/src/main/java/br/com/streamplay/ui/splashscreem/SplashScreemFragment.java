package br.com.streamplay.ui.splashscreem;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.streamplay.Applicattion;
import br.com.streamplay.Constant;
import br.com.streamplay.R;
import br.com.streamplay.callbacks.IHomeCallback;
import br.com.streamplay.database.ArticleContract;
import br.com.streamplay.database.StreamPlayHelper;
import br.com.streamplay.database.VideoContract;
import br.com.streamplay.models.Article;
import br.com.streamplay.models.HomeData;
import br.com.streamplay.models.Video;
import br.com.streamplay.presenters.HomePresenter;
import br.com.streamplay.ui.home.HomeActivity;

/**
 * Created by Antony on 17/12/2017.
 */

public class SplashScreemFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_screem, container, false);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getActivity().startActivity(new Intent(getContext(), HomeActivity.class));
            }
        }, 2000);

        HomePresenter presenter = HomePresenter.getInstance();
        presenter.setHomeServiceCallback(homeCallback);
        presenter.getHomeData();

        return view;
    }

    public void insertData(HomeData data){
        try{

            SQLiteDatabase database = Applicattion.mHelper.getWritableDatabase();

            for(Video video : data.getVideos()){
                VideoContract.create(video, database);
            }

            for (Article article : data.getArticles()){
                ArticleContract.create(article, database);
            }
        }catch (Throwable t){}
    }

    /***
     * Callback
     */

    IHomeCallback homeCallback = new IHomeCallback() {
        @Override
        public void onSuccess(HomeData data) {
            insertData(data);
        }

        @Override
        public void onFailure(Throwable t) {

        }
    };
}
