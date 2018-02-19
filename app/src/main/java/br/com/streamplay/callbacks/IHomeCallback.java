package br.com.streamplay.callbacks;

import br.com.streamplaydomain.briefing.models.Briefing;

/**
 * Created by Antony on 09/12/2017.
 */

public interface IHomeCallback {

    void onSuccess(Briefing data);
    void onFailure(Throwable t);

}
