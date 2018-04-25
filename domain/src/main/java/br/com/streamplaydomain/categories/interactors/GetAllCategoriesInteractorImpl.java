package br.com.streamplaydomain.categories.interactors;

import java.util.List;

import br.com.streamplaydomain.base.AbstractInteractor;
import br.com.streamplaydomain.base.Executor;
import br.com.streamplaydomain.base.MainThread;
import br.com.streamplaydomain.categories.repositories.GetAllCategoriesRepository;
import br.com.streamplaydomain.entities.Article;
import br.com.streamplaydomain.entities.Category;
import br.com.streamplaydomain.video.repositories.GetAllVideosRepository;

public class GetAllCategoriesInteractorImpl extends AbstractInteractor implements GetAllCategoriesInteractor {

    GetAllCategoriesRepository mRepository;
    List<Category> mCategories;
    GetAllCategoriesInteractorImpl.Callback mCallback;


    public GetAllCategoriesInteractorImpl(Executor threadExecutor, MainThread mainThread,
                                          GetAllCategoriesRepository repository, GetAllCategoriesInteractorImpl.Callback callback) {
        super(threadExecutor, mainThread);

        mRepository = repository;
        mCallback = callback;
    }

    @Override
    public void run() {
        mRepository.getAllArticles(new GetAllCategoriesRepository.Callback() {
            @Override
            public void getAllCategoriesSuccess(List<Category> categories) {
                mCategories = categories;
                if(mCategories.isEmpty())
                    onError();
                onSuccess();
            }
        });
    }

    @Override
    public void onSuccess() {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.gettAllCategoriesSuccess(mCategories);
            }
        });
    }

    @Override
    public void onError() {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.gettAllCategoriesSuccess(mCategories);
            }
        });
    }
}
