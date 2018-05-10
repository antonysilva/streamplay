package br.com.streamplay.video.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import br.com.streamplay.R;
import br.com.streamplaydomain.video.VideoEntity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeVideoListAdapter extends RecyclerView.Adapter<HomeVideoListAdapter.ViewHolder> {

    List<VideoEntity> mVideos;
    Context mContext;
    LayoutInflater mLayoutInflater;

    public HomeVideoListAdapter(Context context, List<VideoEntity> videos){
        mContext = context;
        mVideos = videos;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_video_list_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(mVideos.get(position).image_url)
                .into(holder.mImage);

        holder.mMovieTitle.setText(mVideos.get(position).title);
    }

    @Override
    public int getItemCount() {
        return mVideos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.image_movie_avatar)
        ImageView mImage;
        @BindView(R.id.txt_movie_title)
        TextView mMovieTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
