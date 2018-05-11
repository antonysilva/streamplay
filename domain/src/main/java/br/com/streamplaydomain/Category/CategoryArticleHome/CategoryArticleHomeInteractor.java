package br.com.streamplaydomain.Category.CategoryArticleHome;

import java.util.List;

import br.com.streamplaydomain.Base.AbstractInteractor;
import br.com.streamplaydomain.Base.Executor;
import br.com.streamplaydomain.Base.MainThread;
import br.com.streamplaydomain.Category.CategoryEntity;

public class CategoryArticleHomeInteractor extends AbstractInteractor implements CategoryArticleHomeCallback{

    CategoryArticleHomeRepositoryContract mRepository;
    CategoryArticleHomeCallback mCallback;

    public CategoryArticleHomeInteractor(Executor threadExecutor, MainThread mainThread,
                                         CategoryArticleHomeRepositoryContract repository) {
        super(threadExecutor, mainThread);

        mRepository = repository;
    }

    public void getCategory(CategoryArticleHomeCallback callback){
        mCallback = callback;
        mThreadExecutor.execute(this);
    }

    @Override
    public void run() {
        mRepository.getCategory(mCallback);
    }

    @Override
    public void onCategorySuccess(List<CategoryEntity> categoryEntity) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onCategorySuccess(categoryEntity);
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
