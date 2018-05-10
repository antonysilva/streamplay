package br.com.streamplaydata.video.api;

import java.util.List;

import br.com.streamplaydata.base.RetrofitBase;
import br.com.streamplaydata.video.VideoModel;
import br.com.streamplaydata.video.VideoModelMapper;
import br.com.streamplaydata.video.api.callbacks.GetAllVideosCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetAllVideosClient extends RetrofitBase {

    private static GetAllVideosClient instance;

    public static GetAllVideosClient getInstance() {
        if(instance == null)
            instance = new GetAllVideosClient();

        return instance;
    }

    public GetAllVideosClient(){
    }

    public void execute(final GetAllVideosCallback callback){
        try{
            VideoService service = (VideoService) getService(VideoService.class);
            Call<List<VideoModel>> call = service.getAllVideos();

            call.enqueue(new Callback<List<VideoModel>>() {
                @Override
                public void onResponse(Call<List<VideoModel>> call, Response<List<VideoModel>> response) {
                    if(response.isSuccessful()){
                        callback.onSuccess(VideoModelMapper.getInstance().convert(response.body()));
                    }
                }

                @Override
                public void onFailure(Call<List<VideoModel>> call, Throwable t) {
                    callback.onError();
                }
            });
        }catch (Exception ex){

        }
    }

}
