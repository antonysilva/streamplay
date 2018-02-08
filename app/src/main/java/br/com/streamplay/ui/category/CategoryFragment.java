package br.com.streamplay.ui.category;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.streamplay.Constant;
import br.com.streamplay.R;
import br.com.streamplay.adapters.ArticleRecyclerListAdapter;
import br.com.streamplay.adapters.VideoRecyclerListAdapter;
import br.com.streamplay.callbacks.IArticleCallback;
import br.com.streamplay.callbacks.IVideoCallback;
import br.com.streamplay.models.Article;
import br.com.streamplay.models.Video;
import br.com.streamplay.presenters.ArticlePresenter;
import br.com.streamplay.presenters.VideoPresenter;
import br.com.streamplay.ui.article.ArticleActivity;
import br.com.streamplay.ui.video.VideoActivity;
import br.com.streamplay.util.RecyclerItemClickListener;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Antony on 10/12/2017.
 */

public class CategoryFragment extends Fragment {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    List<Article> mArticles;
    List<Video> mVideos;

    String mCategory;
    String mOptions; // options: 'article' / 'video'

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        ButterKnife.bind(this, view);

        mOptions = getArguments().getString(Constant.BUNDLE_OPTION);
        mCategory = getArguments().getString(Constant.BUNDLE_CATEGORY);

        initializeView();

        return view;
    }

    public void initializeView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(linearLayoutManager);
        if(mOptions.equalsIgnoreCase("video")) {
            mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerViewVideoListener));
        }
        getData();
    }


    public void getData(){
        switch (mOptions){
            case "article":
                ArticlePresenter.getInstance().setArticleCallback(articleCallback);
                ArticlePresenter.getInstance().findByCategory(mCategory);
                break;
            case "video":
                VideoPresenter.getInstance().setVideoCallback(videoCallback);
                VideoPresenter.getInstance().findByCategory(mCategory);
                break;
        }
    }

    /***
     * ArticleModel Callback
     */
    IArticleCallback articleCallback = new IArticleCallback() {
        @Override
        public void onSuccess(List<Article> articles) {
            mArticles = articles;
            mRecyclerView.setAdapter(new ArticleRecyclerListAdapter(getContext(), mArticles));
        }

        @Override
        public void onFailure(Throwable t) {

        }
    };

    /***
     * VideoModel Callback
     */
    IVideoCallback videoCallback = new IVideoCallback() {
        @Override
        public void onSuccess(List<Video> videos) {
            mVideos = videos;
            mRecyclerView.setAdapter(new VideoRecyclerListAdapter(getContext(), mVideos));
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
            if(mVideos != null){
                if(mVideos.size() > 0){
                    Intent intent = new Intent(getContext(), VideoActivity.class);
                    intent.putExtra(Constant.BUNDLE_HOME_VIDEO_DATA, mVideos.get(position));
                    startActivity(intent);
                }
            }
        }
    };

}
