package br.com.streamplaydata.services;

import br.com.streamplaydata.breafing.model.Briefing;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public interface HomeService {

    @GET("/home_brief")
    Call<Briefing> getHomeData();

}
