package br.com.streamplay.retrofitservices;

import br.com.streamplay.models.HomeData;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Antony on 09/12/2017.
 */

public interface IHomeService {

    @GET("/home_brief")
    Call<HomeData> getHomeData();

}
