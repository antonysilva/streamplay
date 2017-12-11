package br.com.streamplay.ui.video;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import java.net.URI;
import java.util.List;

import br.com.streamplay.Constant;
import br.com.streamplay.R;
import br.com.streamplay.adapters.ArticleRecyclerListAdapter;
import br.com.streamplay.adapters.VideoRecyclerListAdapter;
import br.com.streamplay.callbacks.IVideoCallback;
import br.com.streamplay.models.Video;
import br.com.streamplay.presenters.VideoPresenter;
import br.com.streamplay.util.RecyclerItemClickListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Antony on 09/12/2017.
 */

public class VideoFragment extends Fragment{

    @BindView(R.id.video_view)
    VideoView mVideoView;
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.description)
    TextView mDescription;
    @BindView(R.id.btn_play_and_pause)
    ImageView mPlayOrPauseButtom;
    @BindView(R.id.btn_full_screem)
    ImageView mFullScreemButtom;
    @BindView(R.id.progress)
    ProgressBar mProgress;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private Uri mUri;
    private Video mVideo;
    private List<Video> mVideoSuggestions;
    private int mStopTime;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);

        ButterKnife.bind(this, view);

        mVideo = (Video) getArguments().getSerializable(Constant.BUNDLE_HOME_VIDEO_DATA);
        mTitle.setText(mVideo.getTitle());
        mDescription.setText(mVideo.getDescription());
        mUri = Uri.parse(mVideo.getVideoUrl());

        initializeRecyclerView();

        VideoPresenter.getInstance().setVideoCallback(videoCallback);
        VideoPresenter.getInstance().findByCategory(mVideo.getCategory());

        return view;
    }

    public void initializeRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerViewVideoListener));
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
        if(mVideoView.isPlaying()){
            mPlayOrPauseButtom.setSelected(!mVideoView.isPlaying());
            mStopTime = mVideoView.getCurrentPosition();
            mVideoView.pause();
        }

        Intent intent = new Intent(getContext(), VideoPlayerActivity.class);
        intent.putExtra(Constant.BUNDLE_HOME_VIDEO_DATA, mVideo);
        startActivity(intent);
    }

    private LinearLayout.LayoutParams getLayoutParams(int size){
        try{
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (48 * size), getResources().getDisplayMetrics()));
            lp.setMargins(
                    0,
                    (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 250, getResources().getDisplayMetrics()),
                    0,
                    (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 250, getResources().getDisplayMetrics())
            );
            return lp;
        }catch (Exception ex){
            return null;
        }


    }


    /***
     * Video Callback
     */
    IVideoCallback videoCallback = new IVideoCallback() {
        @Override
        public void onSuccess(List<Video> videos) {
            try {
                mVideoSuggestions = videos;
                mRecyclerView.setLayoutParams(getLayoutParams(mVideoSuggestions.size()));
                mRecyclerView.setNestedScrollingEnabled(false);
                mRecyclerView.setHasFixedSize(true);
                mRecyclerView.setAdapter(new VideoRecyclerListAdapter(getContext(), mVideoSuggestions));
            }catch (Exception ex){}
        }

        @Override
        public void onFailure(Throwable t) {

        }
    };

    /***
     * Vídeo Touch Listner
     */
    RecyclerItemClickListener.OnItemClickListener recyclerViewVideoListener = new RecyclerItemClickListener.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            if(mVideoSuggestions != null){
                if(mVideoSuggestions.size() > 0){
                    Intent intent = new Intent(getContext(), VideoActivity.class);
                    intent.putExtra(Constant.BUNDLE_HOME_VIDEO_DATA, mVideoSuggestions.get(position));
                    startActivity(intent);
                }
            }
        }
    };

}
