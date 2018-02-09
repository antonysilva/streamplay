package br.com.streamplay.ui.article;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import br.com.streamplay.Constant;
import br.com.streamplay.R;
import br.com.streamplay.ui.video.VideoFragment;
import br.com.streamplaydomain.article.Article;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    Article mArticle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        ButterKnife.bind(this);

        mArticle = (Article) getIntent().getSerializableExtra(Constant.BUNDLE_ARTICLE_DATA);

        setTitle(mArticle.getTitle());

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        startFragment();
    }

    private void startFragment(){
        Bundle args = new Bundle();
        args.putSerializable(Constant.BUNDLE_ARTICLE_DATA, mArticle);

        ArticleFragment fragment = new ArticleFragment();
        fragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_article, fragment);
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
