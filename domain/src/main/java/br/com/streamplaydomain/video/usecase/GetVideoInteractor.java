package br.com.streamplaydomain.video.usecase;

import br.com.streamplaydomain.base.Interactor;
import br.com.streamplaydomain.video.Video;

/**
 * Created by Antony Silva on 07/02/2018.
 */

public interface GetVideoInteractor extends Interactor {

    void getVideo(final Video video);
    void videoNotFound();

}
