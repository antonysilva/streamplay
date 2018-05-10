package br.com.streamplay.video.presenters;

import java.util.List;

import br.com.streamplaydomain.video.VideoEntity;

public interface GetAllVideosHomePresenter {

    void getAllVideosHome();

    interface View{
        void onGetAllVideosHomeSuccess(List<VideoEntity> videos);
    }

}
