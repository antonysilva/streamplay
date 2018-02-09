package br.com.streamplaydomain.briefing.callbacks;

import br.com.streamplaydomain.briefing.model.Briefing;

/**
 * Created by Antony Silva on 09/02/2018.
 */

public interface GetBriefingDataCallback {

    void onGetBriefingDataSuccess(Briefing briefing);
    void onError(Throwable throwable);

}
