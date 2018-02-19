package br.com.streamplaydomain.briefing.repositories;

import br.com.streamplaydomain.briefing.callbacks.GetBriefingDataCallback;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public interface BriefingRepository {

    void getBriefingData(GetBriefingDataCallback callback);

}
