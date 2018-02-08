package br.com.streamplay.ui.video;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
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
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import br.com.streamplay.Constant;
import br.com.streamplay.R;
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
    public VideoView mVideoView;
    @BindView(R.id.title)
    public TextView mTitle;
    @BindView(R.id.description)
    public TextView mDescription;
    @BindView(R.id.video_time)
    public TextView mVideoTime;
    @BindView(R.id.btn_play_and_pause)
    public ImageView mPlayOrPauseButtom;
    @BindView(R.id.btn_full_screem)
    public ImageView mFullScreemButtom;
    @BindView(R.id.progress)
    public ProgressBar mProgress;
    @BindView(R.id.recycler_view)
    public RecyclerView mRecyclerView;
    @BindView(R.id.video_progress)
    public SeekBar mVideoProgress;

    public Uri mUri;
    public Video mVideo;
    public List<Video> mVideoSuggestions;
    public int mStopTime;

    private VideoPlayerPresenter mVideoPlayerPresenter;

    private Handler mHandler = new Handler();

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

        mVideoProgress.setOnSeekBarChangeListener(seekBarChangeListener);

        mVideoPlayerPresenter = new VideoPlayerPresenter(this);

        return view;
    }

    public void initializeRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerViewVideoListener));
    }

    @OnClick(R.id.btn_play_and_pause)
    public void actionStream(){
        mVideoPlayerPresenter.playAndPauseVideo();
    }

    @OnClick(R.id.btn_full_screem)
    public void openFullScreemMode(){
        mVideoPlayerPresenter.openFullScreemMode();
    }

    @OnClick(R.id.btn_share)
    public void startSared(){
        mVideoPlayerPresenter.openSharedBox();
    }

    private LinearLayout.LayoutParams getLayoutParams(int size){
        try{
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (250 * size), getResources().getDisplayMetrics()));
            lp.setMargins(
                    0,
                    (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics()),
                    0,
                    (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics())
            );
            return lp;
        }catch (Exception ex){
            return null;
        }


    }

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
//            updateProgress();
        }
    };

    /***
     * VideoModel Callback
     */
    IVideoCallback videoCallback = new IVideoCallback() {
        @Override
        public void onSuccess(List<Video> videos) {
            try {
                List<Video> lista = new ArrayList<>();

                for (Video video : videos){
                    if(mVideo.getTitle().equalsIgnoreCase(video.getTitle())){
                        continue;
                    }else{
                        lista.add(video);
                    }

                }

                LinearLayoutManager llm = new LinearLayoutManager(getContext());
                llm.setOrientation(LinearLayoutManager.VERTICAL);

                mRecyclerView.setLayoutManager(llm);
                mRecyclerView.setNestedScrollingEnabled(false);
                mRecyclerView.setHasFixedSize(true);
                mRecyclerView.setAdapter(new VideoRecyclerListAdapter(getContext(), lista));
                mRecyclerView.setLayoutParams(getLayoutParams(mVideoSuggestions.size()));
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
