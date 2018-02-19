package br.com.streamplay.retrofitservices;
import br.com.streamplaydomain.briefing.models.Briefing;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Antony on 09/12/2017.
 */

public interface IHomeService {

    @GET("/home_brief")
    Call<Briefing> getHomeData();

}
