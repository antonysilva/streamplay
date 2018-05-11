package br.com.streamplay.home.video;

import java.util.List;

import br.com.streamplay.video.presenters.GetAllVideosHomePresenter;
import br.com.streamplaydomain.Video.GetAllVideos.GetAllVideosCallback;
import br.com.streamplaydomain.Video.GetAllVideos.GetAllVideosInteractor;
import br.com.streamplaydomain.Video.VideoEntity;

public class VideoHomePresenter implements GetAllVideosCallback {

    private GetAllVideosInteractor mGetAllVideosInteractor;
    GetAllVideosHomePresenter.View mView;

    public VideoHomePresenter(GetAllVideosInteractor getAllVideosInteractor, GetAllVideosHomePresenter.View viewCallback){
        this.mGetAllVideosInteractor = getAllVideosInteractor;
        mView = viewCallback;
    }

    public void getVideos(){
        mGetAllVideosInteractor.getAllVideos(this);
    }

    @Override
    public void onSuccess(List<VideoEntity> videos) {
        mView.onGetAllVideosHomeSuccess(videos);
    }

    @Override
    public void onFailure(Throwable throwable) {

    }
}
