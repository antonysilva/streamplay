package br.com.streamplay.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import br.com.streamplay.models.HomeData;

/**
 * Created by Antony on 10/12/2017.
 */

public class SearchableResultAdapter extends RecyclerView.Adapter<SearchableResultAdapter.ViewHolder> {

    HomeData mListData;

    public SearchableResultAdapter(Context context, HomeData data){

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
