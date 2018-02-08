package br.com.streamplay.ui.video;

import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View;

import java.util.concurrent.TimeUnit;
import android.os.Handler;

import br.com.streamplay.Constant;
import br.com.streamplay.ui.video.VideoFragment;
import br.com.streamplay.ui.video.impl.VideoPlayerPresenterImpl;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public class VideoPlayerPresenter implements VideoPlayerPresenterImpl {

    VideoFragment mFragment;
    Handler mHandler = new Handler();

    public VideoPlayerPresenter(VideoFragment videoFragment){
        mFragment = videoFragment;
    }

    @Override
    public void playAndPauseVideo(){
        try{
            if(!mFragment.mVideoView.isPlaying()){
                mFragment.mProgress.setVisibility(View.VISIBLE);
                mFragment.mVideoView.setVideoURI(mFragment.mUri);
                mFragment.mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mFragment.mPlayOrPauseButtom.setSelected(!mFragment.mVideoView.isPlaying());
                    }
                });
            }else{
                mFragment.mPlayOrPauseButtom.setSelected(!mFragment.mVideoView.isPlaying());
                mFragment.mStopTime = mFragment.mVideoView.getCurrentPosition();
                mFragment.mVideoView.pause();
            }
        }catch (Throwable t){}

        mFragment.mVideoView.requestFocus();
        mFragment.mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mFragment.mProgress.setVisibility(View.GONE);
                mFragment.mVideoView.seekTo(mFragment.mStopTime);
                mFragment.mVideoView.start();
                showVideoDuration(mFragment.mVideoView.getDuration());
                mFragment.mPlayOrPauseButtom.setSelected(mFragment.mVideoView.isPlaying());
            }
        });
    }

    @Override
    public void showVideoDuration(long duration) {
        String time = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(duration),
                TimeUnit.MILLISECONDS.toSeconds(duration) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));

        mFragment.mVideoProgress.setProgress(mFragment.mVideoView.getCurrentPosition());
        mFragment.mVideoProgress.setMax(mFragment.mVideoView.getDuration());

        mFragment.mVideoTime.setText(time);
        updateProgress();
    }

    @Override
    public void openFullScreemMode() {
        if(mFragment.mVideoView.isPlaying()){
            mFragment.mPlayOrPauseButtom.setSelected(!mFragment.mVideoView.isPlaying());
            mFragment.mStopTime = mFragment.mVideoView.getCurrentPosition();
            mFragment.mVideoView.pause();
        }

        Intent intent = new Intent(mFragment.getContext(), VideoPlayerActivity.class);
        intent.putExtra(Constant.BUNDLE_HOME_VIDEO_DATA, mFragment.mVideo);
        mFragment.startActivity(intent);
    }

    @Override
    public void openSharedBox() {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = mFragment.mVideo.getShortDescription();
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, mFragment.mVideo.getTitle());
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        mFragment.startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

    private void updateProgress(){
        mHandler.postDelayed(runnable, 100);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if(mFragment.mVideoView.isPlaying()){
                mFragment.mVideoProgress.setProgress(mFragment.mVideoView.getCurrentPosition());
                String time = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(mFragment.mVideoView.getCurrentPosition()),
                        TimeUnit.MILLISECONDS.toSeconds(mFragment.mVideoView.getCurrentPosition()) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(mFragment.mVideoView.getCurrentPosition())));

                mFragment.mVideoTime.setText(time);
                mHandler.postDelayed(this, 100);
            }
        }
    };
}
