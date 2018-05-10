package br.com.streamplay.video;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;

import br.com.streamplay.Constant;
import br.com.streamplay.R;
import br.com.streamplaydomain.video.VideoEntity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    VideoEntity mVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        ButterKnife.bind(this);

        mVideo = (VideoEntity) getIntent().getSerializableExtra(Constant.BUNDLE_HOME_VIDEO_DATA);

        setTitle(mVideo.title);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        startFragment();
    }

    private void startFragment(){
        Bundle args = new Bundle();
        args.putSerializable(Constant.BUNDLE_HOME_VIDEO_DATA, mVideo);

        VideoFragment fragment = new VideoFragment();
        fragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_video, fragment);
        transaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                    finish();
                break;
        }
        return true;
    }

}
