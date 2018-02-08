package br.com.streamplay.ui.video.impl;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public interface VideoPlayerPresenterImpl {

    void playAndPauseVideo();
    void showVideoDuration(long duration);
    void openFullScreemMode();
    void openSharedBox();
}
