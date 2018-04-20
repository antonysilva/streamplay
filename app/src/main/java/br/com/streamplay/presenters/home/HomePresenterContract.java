package br.com.streamplay.presenters.home;

import br.com.streamplaydomain.entities.Briefing;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public interface HomePresenterContract {

    void getAllBriefingData();

    interface View{
        void getBriefingData(Briefing briefing);
    }

}
