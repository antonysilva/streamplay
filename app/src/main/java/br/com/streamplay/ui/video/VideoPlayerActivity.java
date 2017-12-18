package br.com.streamplay.ui.video;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.concurrent.TimeUnit;

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
    @BindView(R.id.video_time)
    TextView mVideoTime;
    @BindView(R.id.video_progress)
    SeekBar mVideoProgress;

    private Uri mUri;
    private Video mVideo;
    private int mStopTime;
    private Handler mHandler = new Handler();

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
        mVideoProgress.setOnSeekBarChangeListener(seekBarChangeListener);
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
                showDuration(mVideoView.getDuration());
            }
        });
    }

    @OnClick(R.id.btn_full_screem)
    public void openFullScreemMode(){
        finish();
    }

    protected void showDuration(int duration){
        String time = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(duration),
                TimeUnit.MILLISECONDS.toSeconds(duration) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));

        mVideoProgress.setProgress(mVideoView.getCurrentPosition());
        mVideoProgress.setMax(mVideoView.getDuration());

        mVideoTime.setText(time);
        updateProgress();
    }

    private void updateProgress(){
        mHandler.postDelayed(runnable, 100);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if(mVideoView.isPlaying()){
                mVideoProgress.setProgress(mVideoView.getCurrentPosition());
                String time = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(mVideoView.getCurrentPosition()),
                        TimeUnit.MILLISECONDS.toSeconds(mVideoView.getCurrentPosition()) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(mVideoView.getCurrentPosition())));
                mVideoTime.setText(time);
                mHandler.postDelayed(this, 100);
            }
        }
    };

    /***
     * SeekBar Listener
     */

    SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            mVideoView.seekTo(mVideoProgress.getProgress());
            updateProgress();
        }
    };
}
