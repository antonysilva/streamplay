package br.com.streamplaydata.video.client;

import java.util.List;

import br.com.streamplaydata.base.RetrofitBase;
import br.com.streamplaydata.video.model.Video;
import br.com.streamplaydata.services.VideoService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Antony Silva on 07/02/2018.
 */

public class VideoClient extends RetrofitBase implements VideoClientImpl {


    @Override
    public void findByCategory(String category) {
        VideoService service = getService(VideoService.class);
        Call<List<Video>> call = service.findByCategory(category);

        call.enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {
                if(response.isSuccessful()){
//                    mCallback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {
//                mCallback.onFailure(t);
            }
        });
    }
}
