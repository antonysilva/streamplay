package br.com.streamplaydomain.briefing.interactors;

import br.com.streamplaydomain.briefing.model.Briefing;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public interface BriefingInteractorCallback {

    void onGetBriefingaDataCallback(Briefing briefing);
    void onGetBriefingaDataFailure(Throwable throwable);

}
