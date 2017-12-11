package br.com.streamplay.ui.home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import br.com.streamplay.Constant;
import br.com.streamplay.R;
import br.com.streamplay.adapters.HomeViewPagerAdapter;
import br.com.streamplay.callbacks.IHomeCallback;
import br.com.streamplay.models.HomeData;
import br.com.streamplay.presenters.HomePresenter;
import br.com.streamplay.ui.category.CategoryActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawer;
    @BindView(R.id.nav_view)
    NavigationView mNavigationView;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;

    private HomePresenter mHomePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        mTabLayout.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#ffffff"));

        mHomePresenter = mHomePresenter.getInstance();

        setSupportActionBar(mToolbar);

        getHomeData();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();


        mNavigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
         if (id == R.id.action_favorite) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Intent intent = new Intent(this, CategoryActivity.class);
        int id = item.getItemId();

        if (id == R.id.nav_video_anime) {
            intent.putExtra(Constant.BUNDLE_OPTION, "video");
            intent.putExtra(Constant.BUNDLE_CATEGORY, "anime");
            startActivity(intent);
        } else if (id == R.id.nav_video_sports) {
            intent.putExtra(Constant.BUNDLE_OPTION, "video");
            intent.putExtra(Constant.BUNDLE_CATEGORY, "sports");
            startActivity(intent);
        } else if (id == R.id.nav_video_technology) {
            intent.putExtra(Constant.BUNDLE_OPTION, "video");
            intent.putExtra(Constant.BUNDLE_CATEGORY, "technology");
            startActivity(intent);
        } else if (id == R.id.nav_video_financial) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /***
     * List all data home
     */
    private void getHomeData(){
        mHomePresenter.setHomeServiceCallback(mHomeCallback);
        mHomePresenter.getHomeData();
    }

    /***
     * HOME SERVICE CALLBACK
     */
    IHomeCallback mHomeCallback = new IHomeCallback() {
        @Override
        public void onSuccess(HomeData data) {
            HomeViewPagerAdapter adapter = new HomeViewPagerAdapter(getSupportFragmentManager(), data);
            mViewPager.setAdapter(adapter);
            mTabLayout.setupWithViewPager(mViewPager);
        }

        @Override
        public void onFailure(Throwable t) {
            String s = "aa";
        }
    };
}
