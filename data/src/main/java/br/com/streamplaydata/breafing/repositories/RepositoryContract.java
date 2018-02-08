package br.com.streamplaydata.breafing.repositories;

import br.com.streamplaydomain.briefing.interactors.BriefingInteractorCallback;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public interface RepositoryContract {

    void getBriefingData(BriefingInteractorCallback callback);

}
