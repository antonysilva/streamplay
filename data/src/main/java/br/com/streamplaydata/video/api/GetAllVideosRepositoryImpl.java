package br.com.streamplaydata.video.api;

import java.util.List;

import br.com.streamplaydomain.Video.GetAllVideos.GetAllVideosCallback;
import br.com.streamplaydomain.Video.GetAllVideos.GetAllVideosRepository;
import br.com.streamplaydomain.Video.VideoEntity;

public class GetAllVideosRepositoryImpl implements GetAllVideosRepository {

    private static GetAllVideosRepositoryImpl instance;

    public static GetAllVideosRepositoryImpl getInstance() {
        if (instance == null)
            instance = new GetAllVideosRepositoryImpl();
        return instance;
    }

    public GetAllVideosRepositoryImpl(){
    }

    @Override
    public void getAllVideos(final GetAllVideosCallback callback) {
        GetAllVideosClient.getInstance().execute(new br.com.streamplaydata.video.api.callbacks.GetAllVideosCallback() {
            @Override
            public void onSuccess(List<VideoEntity> videos) {
                callback.onSuccess(videos);
            }

            @Override
            public void onError() {
                callback.onFailure(new Throwable());
            }
        });
    }

}
