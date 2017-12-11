package br.com.streamplay.ui.video;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import br.com.streamplay.Constant;
import br.com.streamplay.R;
import br.com.streamplay.models.Video;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VideoPlayerActivity extends AppCompatActivity {

    @BindView(R.id.video_view)
    VideoView mVideoView;
    @BindView(R.id.btn_play_and_pause)
    ImageView mPlayOrPauseButtom;
    @BindView(R.id.progress)
    ProgressBar mProgress;

    private Uri mUri;
    private Video mVideo;
    private int mStopTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        ButterKnife.bind(this);

        mVideo = (Video) getIntent().getSerializableExtra(Constant.BUNDLE_HOME_VIDEO_DATA);
        mUri = Uri.parse(mVideo.getVideoUrl());

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);

        mPlayOrPauseButtom.performClick();
    }

    @OnClick(R.id.btn_play_and_pause)
    public void actionStream(){
        try{
            if(!mVideoView.isPlaying()){
                mProgress.setVisibility(View.VISIBLE);
                mVideoView.setVideoURI(mUri);
                mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mPlayOrPauseButtom.setSelected(!mVideoView.isPlaying());
                    }
                });
            }else{
                mPlayOrPauseButtom.setSelected(!mVideoView.isPlaying());
                mStopTime = mVideoView.getCurrentPosition();
                mVideoView.pause();
            }
        }catch (Throwable t){}

        mVideoView.requestFocus();
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mProgress.setVisibility(View.GONE);
                mVideoView.seekTo(mStopTime);
                mVideoView.start();
                mPlayOrPauseButtom.setSelected(mVideoView.isPlaying());
            }
        });
    }

    @OnClick(R.id.btn_full_screem)
    public void openFullScreemMode(){
        finish();
    }
}
