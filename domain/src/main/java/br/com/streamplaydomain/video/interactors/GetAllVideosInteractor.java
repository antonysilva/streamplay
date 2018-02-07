package br.com.streamplaydomain.video.interactors;

import java.util.List;

import br.com.streamplaydomain.base.Interactor;
import br.com.streamplaydomain.video.Video;

/**
 * Created by Antony Silva on 07/02/2018.
 */

public interface GetAllVideosInteractor extends Interactor {

    void getAllVideos(final List<Video> videos);

}
