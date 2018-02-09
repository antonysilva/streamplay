package br.com.streamplay.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
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
import br.com.streamplay.ui.article.ArticleActivity;
import br.com.streamplay.ui.video.VideoActivity;
import br.com.streamplay.util.RecyclerItemClickListener;
import br.com.streamplaydata.breafing.model.BriefingModel;
import br.com.streamplaydomain.briefing.model.Briefing;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Antony on 09/12/2017.
 */

public class HomePagerFragment extends Fragment {

    @BindView(R.id.reciylerView)
    RecyclerView mRecyclerView;

   Briefing mData;
   int mPagerPosition;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        ButterKnife.bind(this, view);

        Bundle args = getArguments();

        mData = (Briefing) args.getSerializable(Constant.BUNDLE_HOME_DATA);
        mPagerPosition =  args.getInt(Constant.BUNDLE_PAGER_POSITION);

        initializeView();

        return view;
    }

    public void initializeView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(linearLayoutManager);
        if(mPagerPosition == 0) {
            mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerViewVideoListener));
            mRecyclerView.setAdapter(new VideoRecyclerListAdapter(getContext(), mData.getVideos()));
        }else if(mPagerPosition == 1){
            mRecyclerView.setAdapter(new ArticleRecyclerListAdapter(getContext(), mData.getArticles()));
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
