package br.com.streamplaydomain.video.GetAllVideos;

import java.util.List;

import br.com.streamplaydomain.video.VideoEntity;

public interface GetAllVideosCallback {
    void onSuccess(List<VideoEntity> videos);
    void onFailure(Throwable throwable);

}
