package br.com.streamplay.article;

import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import br.com.streamplay.Constant;
import br.com.streamplay.R;
import br.com.streamplaydomain.article.ArticleEntity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Antony on 10/12/2017.
 */

public class ArticleFragment extends Fragment {

    @BindView(R.id.web_view)
    WebView mWebView;
    @BindView(R.id.progress)
    ProgressBar mProgress;

    ArticleEntity mArticleEntity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article, container, false);

        ButterKnife.bind(this, view);

        mArticleEntity = (ArticleEntity) getArguments().getSerializable(Constant.BUNDLE_ARTICLE_DATA);

        openArticle();

        return view;
    }

    public void openArticle(){
        mWebView.setWebViewClient( new SSLTolerentWebViewClient() );
        mWebView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress)
            {
                //Make the bar disappear after URL is loaded, and changes string to Loading...
                // Return the app name after finish loading
                if(progress == 100)
                    mProgress.setVisibility(View.GONE);
            }
        });
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mWebView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);
        }

        mWebView.loadUrl(mArticleEntity.article_url);
    }

    private class SSLTolerentWebViewClient extends WebViewClient {

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed(); // Ignore SSL certificate errors
        }

    }
}
