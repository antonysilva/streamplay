package br.com.streamplay.article.presenter;

import java.util.List;

import br.com.streamplay.presenters.ApplicationPresenter;
import br.com.streamplaydomain.base.Executor;
import br.com.streamplaydomain.base.MainThread;
import br.com.streamplaydomain.categories.interactors.GetAllCategoriesInteractor;
import br.com.streamplaydomain.categories.interactors.GetAllCategoriesInteractorImpl;
import br.com.streamplaydomain.categories.repositories.GetAllCategoriesRepository;
import br.com.streamplaydomain.entities.Category;

public class ArticleHomePresenterImpl extends ApplicationPresenter implements ArticleHomePresenter, GetAllCategoriesInteractor.Callback {

    ArticleHomePresenter.View mView;
    GetAllCategoriesRepository mCategoriesRepository;

    public ArticleHomePresenterImpl(Executor executor, MainThread mainThread,
                                    ArticleHomePresenter.View view, GetAllCategoriesRepository categoriesRepository) {
        super(executor, mainThread);

        mView = view;
        mCategoriesRepository = categoriesRepository;
    }

    @Override
    public void getAllCategory() {
        GetAllCategoriesInteractor interactor = new GetAllCategoriesInteractorImpl(
                mExecutor,
                mMainThread,
                mCategoriesRepository,
                this
        );
        interactor.execute();
    }

    @Override
    public void getAllArticle(String category) {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void gettAllCategoriesSuccess(final List<Category> categories) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mView.onGetAllCategorySuccess(categories);
            }
        });
    }
}
