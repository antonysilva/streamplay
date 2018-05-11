package br.com.streamplay.home.video;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import br.com.streamplay.Base.BaseFragment;
import br.com.streamplay.R;
import br.com.streamplay.video.adapters.HomeVideoListAdapter;
import br.com.streamplay.video.presenters.GetAllVideosHomePresenter;
import br.com.streamplaydomain.Video.VideoEntity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoHomeFragment extends BaseFragment implements GetAllVideosHomePresenter.View {

    private static VideoHomeFragment instance;
    private VideoHomePresenter mPresenter;
    @BindView(R.id.list_video_movie)
    public RecyclerView mListMovies;
    @BindView(R.id.list_video_tecnology)
    public RecyclerView mListTecnology;
    @BindView(R.id.list_video_anime)
    public RecyclerView mListAnime;
    @BindView(R.id.list_video_news)
    public RecyclerView mListNews;
    @BindView(R.id.list_video_music)
    public RecyclerView mListMusic;
    @BindView(R.id.list_video_sport)
    public RecyclerView mListSports;
    @BindView(R.id.list_video_games)
    public RecyclerView mListGames;
    @BindView(R.id.main_video)
    public ImageView mMainVideo;


    public static VideoHomeFragment getInstance() {
        if(instance == null)
            instance = new VideoHomeFragment();
        return instance;
    }

    @Override
    public void initialize() {
        mPresenter = new VideoHomePresenter(VideoHomeBuilder.create(getContext()), this);
    }

    @Override
    public void initView(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public int layoutId() {
        return R.layout.page_video_home;
    }

    @Override
    public void initializeCompleted() {
        mListMovies.setLayoutManager(new LinearLayoutManager(getContext()));
        ((LinearLayoutManager) mListMovies.getLayoutManager()).setOrientation(LinearLayoutManager.HORIZONTAL);
        mListTecnology.setLayoutManager(new LinearLayoutManager(getContext()));
        ((LinearLayoutManager) mListTecnology.getLayoutManager()).setOrientation(LinearLayoutManager.HORIZONTAL);
        mListAnime.setLayoutManager(new LinearLayoutManager(getContext()));
        ((LinearLayoutManager) mListAnime.getLayoutManager()).setOrientation(LinearLayoutManager.HORIZONTAL);
        mListNews.setLayoutManager(new LinearLayoutManager(getContext()));
        ((LinearLayoutManager) mListNews.getLayoutManager()).setOrientation(LinearLayoutManager.HORIZONTAL);
        mListMusic.setLayoutManager(new LinearLayoutManager(getContext()));
        ((LinearLayoutManager) mListMusic.getLayoutManager()).setOrientation(LinearLayoutManager.HORIZONTAL);
        mListSports.setLayoutManager(new LinearLayoutManager(getContext()));
        ((LinearLayoutManager) mListSports.getLayoutManager()).setOrientation(LinearLayoutManager.HORIZONTAL);
        mListGames.setLayoutManager(new LinearLayoutManager(getContext()));
        ((LinearLayoutManager) mListGames.getLayoutManager()).setOrientation(LinearLayoutManager.HORIZONTAL);

        mPresenter.getVideos();
    }

    @Override
    public void onGetAllVideosHomeSuccess(List<VideoEntity> videos) {
        if(videos.size() > 0){
            Glide.with(this).load(videos.get(2).image_url).into(mMainVideo);
            mListMovies.setAdapter(new HomeVideoListAdapter(getContext(), getVideoByCategory("movie", videos)));
            mListTecnology.setAdapter(new HomeVideoListAdapter(getContext(), getVideoByCategory("tecnology", videos)));
            mListAnime.setAdapter(new HomeVideoListAdapter(getContext(), getVideoByCategory("anime", videos)));
            mListNews.setAdapter(new HomeVideoListAdapter(getContext(), getVideoByCategory("news", videos)));
            mListMusic.setAdapter(new HomeVideoListAdapter(getContext(), getVideoByCategory("music", videos)));
            mListSports.setAdapter(new HomeVideoListAdapter(getContext(), getVideoByCategory("sport", videos)));
            mListGames.setAdapter(new HomeVideoListAdapter(getContext(), getVideoByCategory("games", videos)));
        }
    }

    private List<VideoEntity> getVideoByCategory(String category, List<VideoEntity> videos){
        List<VideoEntity> list = new ArrayList<>();
        for (VideoEntity video : videos){
            if(video.category.equalsIgnoreCase(category))
                list.add(video);
        }
        return list;
    }

}
