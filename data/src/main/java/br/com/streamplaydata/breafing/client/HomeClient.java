package br.com.streamplaydata.breafing.client;

import br.com.streamplaydata.base.RetrofitBase;
import br.com.streamplaydata.breafing.model.Briefing;
import br.com.streamplaydata.services.HomeService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public class HomeClient extends RetrofitBase implements HomeClientImpl {

    @Override
    public void getHomeData() {
        HomeService service = getService(HomeService.class);
        Call<Briefing> call = service.getHomeData();

        call.enqueue(new Callback<Briefing>() {
            @Override
            public void onResponse(Call<Briefing> call, Response<Briefing> response) {
                if(response.isSuccessful()){
//                    mHomeServiceCallback.onSuccess(response.body());
                }else{
//                    mHomeServiceCallback.onFailure(null);
                }
            }

            @Override
            public void onFailure(Call<Briefing> call, Throwable t) {
//                mHomeServiceCallback.onFailure(t);
            }
        });
    }

}
