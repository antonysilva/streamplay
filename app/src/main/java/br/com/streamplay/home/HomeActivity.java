package br.com.streamplay.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import br.com.streamplay.R;
import br.com.streamplay.UIThread;
import br.com.streamplay.adapters.HomeViewPagerAdapter;
import br.com.streamplay.category.CategoryActivity;
import br.com.streamplay.presenters.home.HomePresenter;
import br.com.streamplay.presenters.home.HomePresenterContract;
import br.com.streamplay.home.article.ArticleHomeFragment;
import br.com.streamplay.home.search.SearchableActivity;
import br.com.streamplay.home.category.CategoryHomeFragment;
import br.com.streamplay.favorite.FavoriteHomeFragment;
import br.com.streamplay.home.profile.ProfileHomeFragment;
import br.com.streamplay.util.BottomNavigationViewHelper;
import br.com.streamplay.home.video.VideoHomeFragment;
import br.com.streamplaydomain.base.ThreadExecutor;
import br.com.streamplaydomain.entities.Briefing;
import br.com.streamplaydata.breafing.repositories.BriefingRepositoryImpl;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener,
                   BottomNavigationView.OnNavigationItemReselectedListener,
                   HomePresenterContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.navigation)
    BottomNavigationView mNavigationView;

    private HomePresenter mHomePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mNavigationView.setOnNavigationItemSelectedListener(this);
        BottomNavigationViewHelper.disableShiftMode(mNavigationView);

        openFragments(VideoHomeFragment.getInstance());

        mHomePresenter = new HomePresenter(
                ThreadExecutor.getInstance(),
                UIThread.getInstance(),
                this,
                new BriefingRepositoryImpl());
        getHomeData();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
         if (id == R.id.action_search) {
             startActivity(new Intent(HomeActivity.this, SearchableActivity.class));
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

        switch (item.getItemId()){
            case R.id.action_videos_navigation:
                openFragments(VideoHomeFragment.getInstance());
                break;
            case R.id.action_articles_navigation:
                openFragments(ArticleHomeFragment.getInstance());
                break;
            case R.id.action_search_navigation:
                openFragments(CategoryHomeFragment.getInstance());
                break;
            case R.id.action_saved_navigation:
                openFragments(FavoriteHomeFragment.getInstance());
                break;
            case R.id.action_profile_navigation:
                openFragments(ProfileHomeFragment.getInstance());
                break;
        }
        return true;
    }

    private void openFragments(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.framelayout_home, fragment)
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .commit();
    }

    /***
     * List all data home
     */
    private void getHomeData(){
//        mHomePresenter.getAllBriefingData();
    }

    @Override
    public void getBriefingData(Briefing briefing) {
        HomeViewPagerAdapter adapter = new HomeViewPagerAdapter(getSupportFragmentManager(), briefing);
    }

    @Override
    public void onNavigationItemReselected(@NonNull MenuItem item) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
