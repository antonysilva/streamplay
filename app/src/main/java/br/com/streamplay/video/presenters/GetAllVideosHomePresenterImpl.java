package br.com.streamplay.video.presenters;

import java.util.List;

import br.com.streamplay.presenters.ApplicationPresenter;
import br.com.streamplaydomain.base.Executor;
import br.com.streamplaydomain.base.MainThread;
import br.com.streamplaydomain.entities.Video;
import br.com.streamplaydomain.video.interactor.GetAllVideosInteractor;
import br.com.streamplaydomain.video.interactor.impl.GetAllVideosInteractorImpl;
import br.com.streamplaydomain.video.repositories.GetAllVideosRepository;

/**
 * Created by Antony on 09/12/2017.
 */

public class GetAllVideosHomePresenterImpl extends ApplicationPresenter implements GetAllVideosHomePresenter, GetAllVideosInteractor.Callback {

    private GetAllVideosRepository mRepository;
    GetAllVideosHomePresenter.View mCallback;

    public GetAllVideosHomePresenterImpl(Executor executor, MainThread mainThread,
                                         GetAllVideosRepository repository,
                                         GetAllVideosHomePresenter.View callback) {
        super(executor, mainThread);

        mRepository = repository;
        mCallback = callback;
    }

    @Override
    public void getAllVideosHome() {
        GetAllVideosInteractor interactor = new GetAllVideosInteractorImpl(
                mExecutor,
                mMainThread,
                mRepository,
                this
        );

        interactor.execute();
    }

    @Override
    public void getAllVideosCallback(List<Video> videos) {
        mCallback.onGetAllVideosHomeSuccess(videos);
    }
}
