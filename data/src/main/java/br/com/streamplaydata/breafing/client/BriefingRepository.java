package br.com.streamplaydata.breafing.client;

import br.com.streamplaydata.breafing.model.BriefingModel;
import br.com.streamplaydata.breafing.repositories.RepositoryContract;
import br.com.streamplaydomain.briefing.interactors.BriefingInteractorCallback;
import br.com.streamplaydomain.briefing.model.Briefing;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public class BriefingRepository implements RepositoryContract{

    private final BriefingClient client;
    private BriefingInteractorCallback interactorCallback;

    public BriefingRepository(BriefingClient client){
        this.client = client;
    }


    @Override
    public void getBriefingData(final BriefingInteractorCallback callback) {
        interactorCallback = callback;

        client.getBriefingData(new BriefingClientCallback() {
            @Override
            public void onResponse(Briefing briefingModel) {
                interactorCallback.onGetBriefingaDataCallback(briefingModel);
            }

            @Override
            public void onFailure(Throwable throwable) {
                interactorCallback.onGetBriefingaDataFailure(throwable);
            }
        });
    }
}
