package br.com.streamplay.ui.search;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.streamplay.Applicattion;
import br.com.streamplay.Constant;
import br.com.streamplay.adapters.ArticleRecyclerListAdapter;
import br.com.streamplay.adapters.SearchableResultAdapter;
import br.com.streamplay.adapters.VideoCardAdapter;
import br.com.streamplay.adapters.VideoRecyclerListAdapter;
import br.com.streamplay.database.ArticleContract;
import br.com.streamplay.database.StreamPlayHelper;
import br.com.streamplay.database.VideoContract;
import br.com.streamplay.models.Article;
import br.com.streamplay.models.HomeData;
import br.com.streamplay.models.Video;
import br.com.streamplay.ui.video.VideoActivity;
import br.com.streamplay.util.RecyclerItemClickListener;
import butterknife.BindView;
import butterknife.ButterKnife;

import br.com.streamplay.R;

public class SearchableActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.recycler_view_video)
    RecyclerView mRecyclerViewVideo;
    @BindView(R.id.recycler_view_article)
    RecyclerView mRecyclerViewArticle;
    @BindView(R.id.video_not_found)
    TextView mNoVideoText;
    @BindView(R.id.article_not_found)
    TextView mNoArticleText;

    LinearLayoutManager mLayoutManagerV;
    LinearLayoutManager mLayoutManagerA;
    VideoRecyclerListAdapter mAdapterVideo;
    ArticleRecyclerListAdapter mAdapterArticle;
    HomeData mListData;

    List<Video> videos = new ArrayList<>();
    List<Article> articles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchable);

        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        mToolbar.setContentInsetsAbsolute(0,0);
        mToolbar.setContentInsetStartWithNavigation(0);

        initView();
    }

    protected void initView() {
        mAdapterVideo = new VideoRecyclerListAdapter(this, new ArrayList<Video>());
        mLayoutManagerV = new LinearLayoutManager(this);
        mLayoutManagerV.setOrientation(LinearLayoutManager.VERTICAL);

        mAdapterArticle = new ArticleRecyclerListAdapter(this, new ArrayList<Article>());
        mLayoutManagerA = new LinearLayoutManager(this);
        mLayoutManagerA.setOrientation(LinearLayoutManager.VERTICAL);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }


        mRecyclerViewVideo.setLayoutManager(mLayoutManagerV);
        mRecyclerViewVideo.setAdapter(mAdapterVideo);
        mRecyclerViewVideo.addOnItemTouchListener(new RecyclerItemClickListener(SearchableActivity.this, recyclerViewVideoListener));

        mRecyclerViewArticle.setLayoutManager(mLayoutManagerA);
        mRecyclerViewArticle.setAdapter(mAdapterArticle);

        handleSearch( getIntent() );
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        setIntent( intent );
        handleSearch( intent );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        SearchView searchView;

        MenuItem item = menu.findItem(R.id.action_application_info_searchable_activity);

        searchView = (SearchView) item.getActionView();
        searchView.setSearchableInfo( searchManager.getSearchableInfo( getComponentName() ) );
        searchView.setQueryHint(getResources().getString(R.string.search_hint));
        searchView.setIconifiedByDefault(false);
        searchView.onActionViewExpanded();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextChange(final String newText) {
                if(newText.length() >= 3){
                    new Handler().post(new Runnable() {
                        @Override
                        public void run() {
                            filterApps(newText);
                        }
                    });
                }
                return true;
            }

            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }
        });

        EditText searchEditText = (EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        searchEditText.setPadding(0, 2, 0, 2);
        return true;
    }

    public void handleSearch(Intent intent){
        if(Intent.ACTION_SEARCH.equalsIgnoreCase(intent.getAction())){
            String q = intent.getStringExtra( SearchManager.QUERY);

            mToolbar.setTitle(q);
            filterApps(q);
        }
    }

    public void filterApps(String q){
        getAppList(q);
    }

    private void getAppList(final String q){
        try{
            videos = new ArrayList<>();
            SQLiteDatabase database = Applicattion.applicationHelper.getWritableDatabase();

            String[] query = { "%" + q.toLowerCase() + "%" };

            videos = getVideos(query, database);
            articles = getArticles(query, database);

            mNoVideoText.setVisibility((videos.size() == 0) ? View.VISIBLE : View.GONE);
            if(videos.size() > 0){
                mAdapterVideo.changeData(videos);
            }else{ mAdapterVideo.changeData(new ArrayList<Video>()); }

            mNoArticleText.setVisibility((articles.size() == 0) ? View.VISIBLE : View.GONE);
            if(articles.size() > 0){
                mAdapterArticle.changeData(articles);
            }else{ mAdapterArticle.changeData(new ArrayList<Article>()); }

        }catch (Throwable t){
            String s = "";
        }

    }

    public List<Video> getVideos(String[] query, SQLiteDatabase database) {
        List<Video> videos = new ArrayList<>();
        try{
            Cursor videoCursor = VideoContract.find(query, database);

            if(videoCursor != null){
                if(videoCursor.moveToFirst()){
                    do{
                        videos.add(
                                new Video(
                                        videoCursor.getInt(videoCursor.getColumnIndex(VideoContract.VideoEntry.COLUMN_NAME_ID)),
                                        videoCursor.getString(videoCursor.getColumnIndex(VideoContract.VideoEntry.COLUMN_NAME_TITLE)),
                                        videoCursor.getString(videoCursor.getColumnIndex(VideoContract.VideoEntry.COLUMN_NAME_DESCRIPTION)),
                                        videoCursor.getString(videoCursor.getColumnIndex(VideoContract.VideoEntry.COLUMN_NAME_CATEGORY)),
                                        videoCursor.getString(videoCursor.getColumnIndex(VideoContract.VideoEntry.COLUMN_NAME_IMAGE_URL)),
                                        videoCursor.getString(videoCursor.getColumnIndex(VideoContract.VideoEntry.COLUMN_NAME_VIDEO_URL)),
                                        null
                                )
                        );
                    }while (videoCursor.moveToNext());
                }
            }
        }catch (Throwable t){}

        return videos;
    }

    public List<Article> getArticles(String[] query, SQLiteDatabase database) {
        List<Article> articles = new ArrayList<>();
        try{
            Cursor articleCursor = ArticleContract.find(query, database);

            if(articleCursor != null){
                if(articleCursor.moveToFirst()){
                    do{
                        articles.add(
                                new Article(
                                        articleCursor.getInt(articleCursor.getColumnIndex(ArticleContract.ArticleEntry.COLUMN_NAME_ID)),
                                        articleCursor.getString(articleCursor.getColumnIndex(ArticleContract.ArticleEntry.COLUMN_NAME_AUTHOR)),
                                        articleCursor.getString(articleCursor.getColumnIndex(ArticleContract.ArticleEntry.COLUMN_NAME_CATEGORY)),
                                        articleCursor.getString(articleCursor.getColumnIndex(ArticleContract.ArticleEntry.COLUMN_NAME_TITLE)),
                                        articleCursor.getString(articleCursor.getColumnIndex(ArticleContract.ArticleEntry.COLUMN_NAME_DESCRIPTION)),
                                        articleCursor.getString(articleCursor.getColumnIndex(ArticleContract.ArticleEntry.COLUMN_NAME_IMAGE)),
                                        articleCursor.getString(articleCursor.getColumnIndex(ArticleContract.ArticleEntry.COLUMN_NAME_ARTICLE_URL)),
                                        articleCursor.getString(articleCursor.getColumnIndex(ArticleContract.ArticleEntry.COLUMN_NAME_PUBLISHED_AT))
                                )
                        );
                    }while (articleCursor.moveToNext());
                }
            }
        }catch (Throwable t){}
        return articles;
    }


    /***
     * Vídeo Touch Listner
     */
    RecyclerItemClickListener.OnItemClickListener recyclerViewVideoListener = new RecyclerItemClickListener.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            if(videos != null){
                if(videos.size() > 0){
                    Intent intent = new Intent(SearchableActivity.this, VideoActivity.class);
                    intent.putExtra(Constant.BUNDLE_HOME_VIDEO_DATA, videos.get(position));
                    startActivity(intent);
                }
            }
        }
    };

}
