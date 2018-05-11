package br.com.streamplay.home.article;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import br.com.streamplay.R;
import br.com.streamplaydomain.Article.ArticleEntity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleHomeRecyclerViewAdapter extends RecyclerView.Adapter<ArticleHomeRecyclerViewAdapter.ViewHolder> {

    List<ArticleEntity> mItems;
    Context mContext;

    public ArticleHomeRecyclerViewAdapter(Context context, List<ArticleEntity> items){
        mContext = context;
        mItems = items;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_list_article, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(holder.itemView).load(mItems.get(position).image).into(holder.authorAvatar);
        holder.articleTitle.setText(mItems.get(position).title);
        holder.articleDescription.setText(mItems.get(position).description);
        holder.authorName.setText(mItems.get(position).author);
        holder.articlearticlePublishedAt.setText(mItems.get(position).published_at);

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.author_avatar)
        public ImageView authorAvatar;
        @BindView(R.id.author_name)
        public TextView authorName;
        @BindView(R.id.article_title)
        public TextView articleTitle;
        @BindView(R.id.article_description)
        public TextView articleDescription;
        @BindView(R.id.article_published_at)
        public TextView articlearticlePublishedAt;



        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
