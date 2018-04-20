package br.com.streamplaydomain.video.interactor;

import java.util.List;

import br.com.streamplaydomain.base.Interactor;
import br.com.streamplaydomain.entities.User;
import br.com.streamplaydomain.entities.Video;

public interface GetAllVideosInteractor extends Interactor {

    void onSuccess();
    void onError();

    interface Callback{
        void getAllVideosCallback(List<Video> videos);
    }

}
