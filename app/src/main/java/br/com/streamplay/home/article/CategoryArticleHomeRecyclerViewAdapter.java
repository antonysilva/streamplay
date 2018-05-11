package br.com.streamplay.home.article;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.streamplay.R;
import br.com.streamplaydomain.Category.CategoryEntity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryArticleHomeRecyclerViewAdapter extends RecyclerView.Adapter<CategoryArticleHomeRecyclerViewAdapter.ViewHolder> {

    Context mContext;
    List<CategoryEntity> mItems;

    public CategoryArticleHomeRecyclerViewAdapter(Context context, List<CategoryEntity> items){
        mContext = context;
        mItems = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_category_article_home, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.CategoryName.setText(mItems.get(position).name);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.name)
        TextView CategoryName;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }

}
