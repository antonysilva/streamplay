package br.com.streamplay.callbacks;

import java.util.List;

import br.com.streamplay.models.HomeData;
import br.com.streamplay.models.Video;

/**
 * Created by Antony on 10/12/2017.
 */

public interface IVideoCallback {

    void onSuccess(List<Video> video);
    void onFailure(Throwable t);

}
