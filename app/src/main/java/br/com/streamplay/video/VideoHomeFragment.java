package br.com.streamplay.video;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import br.com.streamplay.Base.BaseFragment;
import br.com.streamplay.R;
import br.com.streamplay.UIThread;
import br.com.streamplay.video.adapters.HomeVideoListAdapter;
import br.com.streamplay.video.presenters.GetAllVideosHomePresenter;
import br.com.streamplay.video.presenters.GetAllVideosHomePresenterImpl;
import br.com.streamplaydata.video.repositories.GetAllVideosRepositoryImpl;
import br.com.streamplaydomain.base.ThreadExecutor;
import br.com.streamplaydomain.entities.Video;
import butterknife.BindView;

public class VideoHomeFragment extends BaseFragment implements GetAllVideosHomePresenter.View {

    private static VideoHomeFragment instance;
    private GetAllVideosHomePresenter mPresenter;
    private LinearLayoutManager mLayoutManager;
    @BindView(R.id.list_video_movie)
    private RecyclerView mListMovies;
    @BindView(R.id.list_video_tecnology)
    private RecyclerView mListTecnology;
    @BindView(R.id.list_video_anime)
    private RecyclerView mListAnime;
    @BindView(R.id.list_video_news)
    private RecyclerView mListNews;
    @BindView(R.id.list_video_music)
    private RecyclerView mListMusic;

    public static VideoHomeFragment getInstance() {
        if(instance == null)
            instance = new VideoHomeFragment();
        return instance;
    }

    @Override
    public void initialize() {
        mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        mListMovies.setLayoutManager(mLayoutManager);
        mListTecnology.setLayoutManager(mLayoutManager);
        mListAnime.setLayoutManager(mLayoutManager);
        mListNews.setLayoutManager(mLayoutManager);
        mListMusic.setLayoutManager(mLayoutManager);

        mPresenter = new GetAllVideosHomePresenterImpl(ThreadExecutor.getInstance(),
                                                       UIThread.getInstance(),
                                                       new GetAllVideosRepositoryImpl(),
                                                       this);
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public int layoutId() {
        return R.layout.page_video_home;
    }

    @Override
    public void initializeCompleted() {
        mPresenter.getAllVideosHome();
    }

    @Override
    public void onGetAllVideosHomeSuccess(List<Video> videos) {
        if(videos.size() > 0){
            HomeVideoListAdapter adapter = new HomeVideoListAdapter(getContext(), videos);
            mListMovies.setAdapter(adapter);
        }
    }

    private List<Video> getVideoByCategory(String category, List<Video> videos){
        List<Video> list = new ArrayList<>();
        for (Video video : videos){
            if(video.getCategory().equalsIgnoreCase(category))
                list.add(video);
        }
        return list;
    }

}
