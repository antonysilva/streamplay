package br.com.streamplaydata.breafing.client;

import br.com.streamplaydomain.briefing.models.Briefing;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public interface BriefingClientCallback {

    void onResponse(Briefing briefing);
    void onError(Throwable throwable);

}
