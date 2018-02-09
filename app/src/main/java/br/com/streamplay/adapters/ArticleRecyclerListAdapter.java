package br.com.streamplay.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.streamplay.Constant;
import br.com.streamplay.R;
import br.com.streamplay.ui.article.ArticleActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Antony on 10/12/2017.
 */

public class ArticleRecyclerListAdapter extends  RecyclerView.Adapter<ArticleRecyclerListAdapter.ViewHolder>{

    private List<br.com.streamplaydomain.article.Article> mArticles;
    private LayoutInflater mInflater;
    private Context mContext;

    public ArticleRecyclerListAdapter(Context context, List<br.com.streamplaydomain.article.Article> articles){
        mArticles = articles;
        mContext = context;
        mInflater = (LayoutInflater) context.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mInflater.inflate(R.layout.item_card_view_article, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ArticleActivity.class);
                intent.putExtra(Constant.BUNDLE_ARTICLE_DATA, mArticles.get(position));
                mContext.startActivity(intent);
            }
        };

        View.OnClickListener listenerFvorite = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int favorite = (!holder.mTxFavorite.getText().toString().isEmpty()) ? Integer.parseInt(holder.mTxFavorite.getText().toString()) + 1 : 1;
                holder.mTxFavorite.setText(String.valueOf(favorite));
            }
        };

        holder.mAuthor.setOnClickListener(listener);
        holder.mTitle.setOnClickListener(listener);
        holder.mDescription.setOnClickListener(listener);
        holder.mImage.setOnClickListener(listener);
        holder.mFavirite.setOnClickListener(listenerFvorite);

        holder.mAuthor.setText(mArticles.get(position).getAuthor());
        holder.mTitle.setText(mArticles.get(position).getTitle());
        holder.mDescription.setText(mArticles.get(position).getDescription());
        Picasso.with(mContext)
               .load(mArticles.get(position)
               .getImage())
               .into(holder.mImage);
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.author)
        TextView mAuthor;
        @BindView(R.id.title)
        TextView mTitle;
        @BindView(R.id.tx_favorite)
        TextView mTxFavorite;
        @BindView(R.id.description)
        TextView mDescription;
        @BindView(R.id.main_image)
        ImageView mImage;
        @BindView(R.id.favirite)
        ImageView mFavirite;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void changeData(List<br.com.streamplaydomain.article.Article> articles){
        mArticles = articles;
        notifyDataSetChanged();
    }


}
