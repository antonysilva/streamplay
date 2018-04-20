package br.com.streamplay.video.presenters;

import java.util.List;

import br.com.streamplaydomain.entities.Video;

public interface GetAllVideosHomePresenter {

    void getAllVideosHome();

    interface View{
        void onGetAllVideosHomeSuccess(List<Video> videos);
    }

}
