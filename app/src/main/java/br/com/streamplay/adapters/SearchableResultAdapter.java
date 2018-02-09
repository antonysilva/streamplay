package br.com.streamplay.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import br.com.streamplaydomain.briefing.model.Briefing;

/**
 * Created by Antony on 10/12/2017.
 */

public class SearchableResultAdapter extends RecyclerView.Adapter<SearchableResultAdapter.ViewHolder> {

    Briefing mListData;

    public SearchableResultAdapter(Context context, Briefing data){

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
