package br.com.streamplay.splashscreem;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.streamplay.Applicattion;
import br.com.streamplay.R;
import br.com.streamplay.database.ArticleContract;
import br.com.streamplay.database.VideoContract;
import br.com.streamplay.presenters.home.HomePresenter;
import br.com.streamplay.home.HomeActivity;
import br.com.streamplay.login.views.LoginActivity;
import br.com.streamplaydomain.article.ArticleEntity;
import br.com.streamplaydomain.entities.Briefing;
import br.com.streamplaydomain.video.VideoEntity;

/**
 * Created by Antony on 17/12/2017.
 */

public class SplashScreemFragment extends Fragment {

    HomePresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_screem, container, false);

        startActivity(new Intent(getContext(), LoginActivity.class));

//        mPresenter = HomePresenter.getInstance();
//        mPresenter.setHomeServiceCallback(homeCallback);
//        mPresenter.getHomeData();

        return view;
    }

    public void insertData(Briefing data){
        try{
            SQLiteDatabase database = Applicattion.applicationHelper.getWritableDatabase();

            for(VideoEntity video : data.getVideos()){
                String[] id = { String.valueOf(video.id) };
                Cursor cursor = VideoContract.findById(id, database);
                if(cursor != null){
                    if(!cursor.moveToFirst()){ VideoContract.create(video, database); }
                }else{ VideoContract.create(video, database); }
            }

            for (ArticleEntity articleEntity : data.getArticleEntities()){
                String[] id = { String.valueOf(articleEntity.id) };
                Cursor cursor = ArticleContract.findById(id, database);
                if(cursor != null){
                    if(!cursor.moveToFirst()){ ArticleContract.create(articleEntity, database); }
                }else{ ArticleContract.create(articleEntity, database); }
            }
        }catch (Throwable t){ }
    }

    public synchronized void openHome(){
       getActivity().startActivity(new Intent(getContext(), HomeActivity.class));
    }

    /***
     * Callback
     */

//    IHomeCallback homeCallback = new IHomeCallback() {
//        @Override
//        public void onSuccess(HomeData data) {
//            insertData(data);
//            openHome();
//        }
//
//        @Override
//        public void onFailure(Throwable t) {
//            if(t instanceof java.net.ConnectException){
//                mPresenter.getHomeData();
//            }
//        }
//    };
}
