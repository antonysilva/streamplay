package br.com.streamplaydata.video.repositories;

import java.util.ArrayList;
import java.util.List;

import br.com.streamplaydata.video.callbacks.GetAllVideosCallback;
import br.com.streamplaydata.video.clients.GetAllVideosClient;
import br.com.streamplaydomain.entities.Video;
import br.com.streamplaydomain.video.repositories.GetAllVideosRepository;

public class GetAllVideosRepositoryImpl implements GetAllVideosRepository {

    private static GetAllVideosRepositoryImpl instance;
    List<Video> mVideo;

    public static GetAllVideosRepositoryImpl getInstance() {
        if (instance == null)
            instance = new GetAllVideosRepositoryImpl();
        return instance;
    }

    public GetAllVideosRepositoryImpl(){
    }

    @Override
    public List<Video> getAllVideos() {
        GetAllVideosClient.getInstance().execute(new GetAllVideosCallback() {
            @Override
            public void onSuccess(List<Video> videos) {
                mVideo = videos;
            }

            @Override
            public void onError() {
                mVideo = new ArrayList<>();
            }
        });
        return mVideo;
    }

}
