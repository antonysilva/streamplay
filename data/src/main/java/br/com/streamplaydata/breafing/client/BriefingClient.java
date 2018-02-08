package br.com.streamplaydata.breafing.client;

import br.com.streamplaydata.base.RetrofitBase;
import br.com.streamplaydata.breafing.mappers.BriefingMapper;
import br.com.streamplaydata.breafing.model.BriefingModel;
import br.com.streamplaydata.services.HomeService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public class BriefingClient extends RetrofitBase {

    BriefingMapper briefingMapper;

    public BriefingClient(){
        briefingMapper = new BriefingMapper();
    }

    public void getBriefingData(final BriefingClientCallback callback) {
        HomeService service = getService(HomeService.class);
        Call<BriefingModel> call = service.getHomeData();

        call.enqueue(new Callback<BriefingModel>() {
            @Override
            public void onResponse(Call<BriefingModel> call, Response<BriefingModel> response) {
                if(response.isSuccessful()){
                    callback.onResponse(briefingMapper.fromDataToDomain(response.body()));
//                    mHomeServiceCallback.onSuccess(response.body());
                }else{
                    callback.onFailure(null);
//                    mHomeServiceCallback.onFailure(null);
                }
            }

            @Override
            public void onFailure(Call<BriefingModel> call, Throwable t) {
                callback.onFailure(t);
//                mHomeServiceCallback.onFailure(t);
            }
        });
    }


}
