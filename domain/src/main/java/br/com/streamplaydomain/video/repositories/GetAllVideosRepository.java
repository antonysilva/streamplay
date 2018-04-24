package br.com.streamplaydomain.video.repositories;

import java.util.List;

import br.com.streamplaydomain.entities.Video;

public interface GetAllVideosRepository {

    void getAllVideos(GetAllVideosRepository.Callback callback);

    interface Callback{
        void getAllVideoSuccess(List<Video> videos);
    }

}
