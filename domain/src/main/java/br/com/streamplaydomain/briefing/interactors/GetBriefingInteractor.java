package br.com.streamplaydomain.briefing.interactors;

import br.com.streamplaydomain.base.Interactor;
import br.com.streamplaydomain.entities.Briefing;

/**
 * Created by Antony Silva on 09/02/2018.
 */

public interface GetBriefingInteractor extends Interactor{

    interface Callback{
        void onGetBriefingSuccess(Briefing briefing);
    }

}
