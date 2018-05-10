package br.com.streamplay.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import br.com.streamplay.Base.BaseFragment;
import br.com.streamplay.Constant;
import br.com.streamplay.R;
import br.com.streamplay.adapters.ArticleRecyclerListAdapter;
import br.com.streamplay.video.VideoActivity;
import br.com.streamplay.util.RecyclerItemClickListener;
import br.com.streamplaydomain.entities.Briefing;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Antony on 09/12/2017.
 */

public class HomePagerFragment extends BaseFragment {

    @BindView(R.id.reciylerView)
    RecyclerView mRecyclerView;

    Briefing mData;
    int mPagerPosition;
    Bundle mArgs;

    @Override
    public void initialize() {
        mArgs = getArguments();
    }

    @Override
    public void initView(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public int layoutId() {
        return R.layout.fragment_list;
    }

    @Override
    public void initializeCompleted() {
        mData = (Briefing) mArgs.getSerializable(Constant.BUNDLE_HOME_DATA);
        mPagerPosition =  mArgs.getInt(Constant.BUNDLE_PAGER_POSITION);
    }

    public void initializeView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        if(mPagerPosition == 0) {
            mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerViewVideoListener));
//            mRecyclerView.setAdapter(new VideoRecyclerListAdapter(getContext(), mData.getVideos()));
        }else if(mPagerPosition == 1){
            mRecyclerView.setAdapter(new ArticleRecyclerListAdapter(getContext(), mData.getArticleEntities()));
        }
    }

    /***
     * Vídeo Touch Listner
     */
    RecyclerItemClickListener.OnItemClickListener recyclerViewVideoListener = new RecyclerItemClickListener.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            if(mData != null){
                if(mData.getVideos().size() > 0){
                    Intent intent = new Intent(getContext(), VideoActivity.class);

                    intent.putExtra(Constant.BUNDLE_HOME_VIDEO_DATA, mData.getVideos().get(position));
                    startActivity(intent);
                }
            }
        }
    };


}
