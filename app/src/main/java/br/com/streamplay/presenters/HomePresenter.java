package br.com.streamplay.presenters;

import br.com.streamplay.callbacks.IHomeCallback;
import retrofit2.Call;

import br.com.streamplay.retrofitservices.IHomeService;
import br.com.streamplay.models.HomeData;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Antony on 09/12/2017.
 */

public class HomePresenter extends ApplicationPresenter{

    private static HomePresenter instance;
    private IHomeCallback mHomeServiceCallback;

    public static HomePresenter getInstance(){
        if(instance == null)
            instance = new HomePresenter();

        return instance;
    }

    public void getHomeData(){
        IHomeService service = getConection().create(IHomeService.class);
        Call<HomeData> call = service.getHomeData();

        call.enqueue(new Callback<HomeData>() {
            @Override
            public void onResponse(Call<HomeData> call, Response<HomeData> response) {
                if(response.isSuccessful()){
                    mHomeServiceCallback.onSuccess(response.body());
                }else{
                    mHomeServiceCallback.onFailure(null);
                }
            }

            @Override
            public void onFailure(Call<HomeData> call, Throwable t) {
                mHomeServiceCallback.onFailure(t);
            }
        });

    }


    public void setHomeServiceCallback(IHomeCallback homeCallback){
        mHomeServiceCallback = homeCallback;
    }


}
