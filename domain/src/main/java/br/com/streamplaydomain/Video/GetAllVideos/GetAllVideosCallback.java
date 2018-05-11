package br.com.streamplaydomain.Video.GetAllVideos;

import java.util.List;

import br.com.streamplaydomain.Video.VideoEntity;

public interface GetAllVideosCallback {
    void onSuccess(List<VideoEntity> videos);
    void onFailure(Throwable throwable);

}
