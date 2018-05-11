package br.com.streamplaydata.video.api.callbacks;

import java.util.List;

import br.com.streamplaydomain.Video.VideoEntity;

public interface GetAllVideosCallback {

    void onSuccess(List<VideoEntity> videos);
    void onError();

}
