package br.com.streamplay.providers;

import android.content.SearchRecentSuggestionsProvider;

import br.com.streamplay.Constant;

/**
 * Created by Antony on 16/12/2017.
 */

public class SearchViewProvider extends SearchRecentSuggestionsProvider{

    public final static String AUTHORITY = Constant.SEARCH_VEW_AUTHORITY;
    public final static int MODE = DATABASE_MODE_QUERIES;

    public SearchViewProvider(){
        setupSuggestions(AUTHORITY, MODE);
    }

}
