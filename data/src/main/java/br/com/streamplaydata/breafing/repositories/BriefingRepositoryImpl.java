package br.com.streamplaydata.breafing.repositories;

import br.com.streamplaydata.breafing.client.BriefingClient;
import br.com.streamplaydata.breafing.client.BriefingClientCallback;
import br.com.streamplaydomain.briefing.callbacks.GetBriefingDataCallback;
import br.com.streamplaydomain.briefing.interactors.impl.GetBriefingInteractorCallback;
import br.com.streamplaydomain.briefing.model.Briefing;
import br.com.streamplaydomain.briefing.repositories.BriefingRepository;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public class BriefingRepositoryImpl implements BriefingRepository {

    BriefingClient mClient;

    public BriefingRepositoryImpl(){
        mClient = new BriefingClient();
    }

    @Override
    public void getBriefingData(final GetBriefingDataCallback callback) {
        mClient.getBriefingData(new BriefingClientCallback() {
            @Override
            public void onResponse(Briefing briefing) {
                callback.onGetBriefingDataSuccess(briefing);
            }

            @Override
            public void onError(Throwable throwable) {
                callback.onError(throwable);
            }
        });
    }

//
//    public Briefing getBriefingData() {
//        client.getBriefingData(this);
//        return null;
//    }

}
