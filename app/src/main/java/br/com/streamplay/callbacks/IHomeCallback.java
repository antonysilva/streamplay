package br.com.streamplay.callbacks;

import br.com.streamplay.models.HomeData;

/**
 * Created by Antony on 09/12/2017.
 */

public interface IHomeCallback {

    void onSuccess(HomeData data);
    void onFailure(Throwable t);

}
