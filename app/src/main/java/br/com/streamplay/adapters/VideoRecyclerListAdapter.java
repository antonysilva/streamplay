package br.com.streamplay.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.streamplay.R;
import br.com.streamplaydomain.entities.Video;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Antony on 10/12/2017.
 */

public class VideoRecyclerListAdapter extends  RecyclerView.Adapter<VideoRecyclerListAdapter.ViewHolder> {

    private List<Video> mVideos;
    private LayoutInflater mInflater;
    private Context mContext;

    public VideoRecyclerListAdapter(Context context, List<Video> videos){
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
        holder.mTitle.setText(mVideos.get(position).getTitle());
        holder.mDescription.setText(mVideos.get(position).getDescription());
        Picasso.with(mContext)
                .load(mVideos.get(position)
                        .getImage_url())
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

    public void changeData(List<Video> videos){
        mVideos = videos;
        notifyDataSetChanged();
    }
}
