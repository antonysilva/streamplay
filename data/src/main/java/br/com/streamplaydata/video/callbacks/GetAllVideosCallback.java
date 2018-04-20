package br.com.streamplaydata.video.callbacks;

import java.util.List;

import br.com.streamplaydomain.entities.Video;

public interface GetAllVideosCallback {

    void onSuccess(List<Video> videos);
    void onError();

}
