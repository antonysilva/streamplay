package br.com.streamplaydata.breafing.repositories;

import br.com.streamplaydomain.briefing.callbacks.GetBriefingDataCallback;
import br.com.streamplaydomain.briefing.models.Briefing;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public interface BriefingRepositoryContract {

    interface GetBriefingCallback{
        void onGetBriefingSuccess(Briefing briefing);
        void onError(Throwable throwable);
    }

    void getBriefingData(GetBriefingDataCallback callback);

}
