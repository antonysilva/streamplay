package br.com.streamplay.adapters;

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

/**
 * Created by Antony on 10/12/2017.
 */

public class VideoRecyclerListAdapter extends  RecyclerView.Adapter<VideoRecyclerListAdapter.ViewHolder> {

    private List<VideoEntity> mVideos;
    private LayoutInflater mInflater;
    private Context mContext;

    public VideoRecyclerListAdapter(Context context, List<VideoEntity> videos){
        mVideos = videos;
        mContext = context;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public VideoRecyclerListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VideoRecyclerListAdapter.ViewHolder(mInflater.inflate(R.layout.item_card_view_video, parent, false));
    }

    @Override
    public void onBindViewHolder(VideoRecyclerListAdapter.ViewHolder holder, int position) {
        holder.mTitle.setText(mVideos.get(position).title);
        holder.mDescription.setText(mVideos.get(position).description);
        Glide.with(holder.itemView)
                .load(mVideos.get(position)
                        .image_url)
                .into(holder.mImage);
    }

    @Override
    public int getItemCount() {
        return mVideos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.title)
        TextView mTitle;
        @BindView(R.id.description)
        TextView mDescription;
        @BindView(R.id.main_image)
        ImageView mImage;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void changeData(List<VideoEntity> videos){
        mVideos = videos;
        notifyDataSetChanged();
    }
}
