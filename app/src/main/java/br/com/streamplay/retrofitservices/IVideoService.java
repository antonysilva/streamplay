package br.com.streamplay.retrofitservices;

import java.util.List;

import br.com.streamplaydomain.Video.VideoEntity;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Antony on 09/12/2017.
 */

public interface IVideoService {

    @GET("/videos/category/{category}")
    Call<List<VideoEntity>> findByCategory(@Path("category") String category);

}
