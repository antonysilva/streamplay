package br.com.streamplay.category.presenters;

import java.util.List;

import br.com.streamplay.UIThread;
import br.com.streamplay.presenters.ApplicationPresenter;
import br.com.streamplay.video.presenters.GetAllVideosHomePresenter;
import br.com.streamplaydomain.base.Executor;
import br.com.streamplaydomain.base.MainThread;
import br.com.streamplaydomain.base.ThreadExecutor;
import br.com.streamplaydomain.categories.interactors.GetAllCategoriesInteractor;
import br.com.streamplaydomain.categories.interactors.GetAllCategoriesInteractorImpl;
import br.com.streamplaydomain.categories.repositories.GetAllCategoriesRepository;
import br.com.streamplaydomain.entities.Category;

public class GetAllCategoriesHomePresenterImpl extends ApplicationPresenter implements GetAllVideosHomePresenter, GetAllCategoriesInteractor.Callback {

    GetAllCategoriesHomePresenter.View mCallback;
    GetAllCategoriesRepository mRepository;

    public GetAllCategoriesHomePresenterImpl(Executor executor, MainThread mainThread,
                                             GetAllCategoriesHomePresenter.View callback,
                                             GetAllCategoriesRepository repository) {
        super(executor, mainThread);

        mCallback = callback;
        mRepository = repository;
    }

    @Override
    public void getAllVideosHome() {
        GetAllCategoriesInteractor interactor = new GetAllCategoriesInteractorImpl(
                ThreadExecutor.getInstance(),
                UIThread.getInstance(),
                mRepository,
                this
        );
        interactor.execute();
    }

    @Override
    public void gettAllCategoriesSuccess(List<Category> categories) {
        mCallback.onGetAllCategoriesHomeSuccess(categories);
    }
}
