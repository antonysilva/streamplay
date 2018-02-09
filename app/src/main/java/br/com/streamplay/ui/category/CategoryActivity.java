package br.com.streamplay.ui.category;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import br.com.streamplay.Constant;
import br.com.streamplay.R;
import br.com.streamplay.adapters.ArticleRecyclerListAdapter;
import br.com.streamplay.adapters.VideoRecyclerListAdapter;
import br.com.streamplay.callbacks.IArticleCallback;
import br.com.streamplay.callbacks.IVideoCallback;
import br.com.streamplay.presenters.ArticlePresenter;
import br.com.streamplay.presenters.VideoPresenter;
import br.com.streamplay.ui.video.VideoActivity;
import br.com.streamplay.util.RecyclerItemClickListener;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    private Bundle args;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        args = getIntent().getExtras();

        ButterKnife.bind(this);

        setTitle(args.getString(Constant.BUNDLE_CATEGORY));

        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initializeView();
    }

    private void initializeView(){
        CategoryFragment fragment = new CategoryFragment();
        fragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_list, fragment);
        transaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return true;
    }



}

