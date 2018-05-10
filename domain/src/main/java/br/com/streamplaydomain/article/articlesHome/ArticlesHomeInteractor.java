package br.com.streamplaydomain.article.articlesHome;

import java.util.List;

import br.com.streamplaydomain.article.ArticleEntity;
import br.com.streamplaydomain.base.AbstractInteractor;
import br.com.streamplaydomain.base.Executor;
import br.com.streamplaydomain.base.MainThread;

public class ArticlesHomeInteractor extends AbstractInteractor implements ArticlesHomeCallback {

    private ArticlesHomeCallback mCallback;
    private ArticlesHomeRepositoryContract mRepository;

    public ArticlesHomeInteractor(Executor threadExecutor, MainThread mainThread, ArticlesHomeRepositoryContract repository) {
        super(threadExecutor, mainThread);

        mRepository = repository;
    }

    public void getArticles(ArticlesHomeCallback callback){
        mCallback = callback;
        mThreadExecutor.execute(this);
    }

    @Override
    public void run() {
        mRepository.getArticlesHome();
    }

    @Override
    public void onSuccess(List<ArticleEntity> articles) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onSuccess(articles);
            }
        });

    }

    @Override
    public void onFailure(Throwable throwable) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onFailure(throwable);
            }
        });
    }
}
