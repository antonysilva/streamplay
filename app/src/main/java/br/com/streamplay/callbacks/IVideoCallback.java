package br.com.streamplay.callbacks;

import java.util.List;

/**
 * Created by Antony on 10/12/2017.
 */

public interface IVideoCallback {

    void onSuccess(List<br.com.streamplaydomain.video.Video> video);
    void onFailure(Throwable t);

}
