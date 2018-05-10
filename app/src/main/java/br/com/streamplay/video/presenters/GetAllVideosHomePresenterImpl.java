package br.com.streamplay.video.presenters;

import java.util.List;

import br.com.streamplay.presenters.ApplicationPresenter;
import br.com.streamplaydomain.video.GetAllVideos.GetAllVideosCallback;
import br.com.streamplaydomain.base.Executor;
import br.com.streamplaydomain.base.MainThread;
import br.com.streamplaydomain.video.GetAllVideos.GetAllVideosInteractor;
import br.com.streamplaydomain.video.GetAllVideos.GetAllVideosRepository;
import br.com.streamplaydomain.video.VideoEntity;

/**
 * Created by Antony on 09/12/2017.
 */

public class GetAllVideosHomePresenterImpl extends ApplicationPresenter implements GetAllVideosHomePresenter, GetAllVideosCallback {

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
//        GetAllVideosInteractor interactor = new GetAllVideosInteractor(
//                mExecutor,
//                mMainThread,
//                mRepository,
//                this
//        );
//
//        interactor.execute();
    }

    @Override
    public void onSuccess(List<VideoEntity> videos) {
        mCallback.onGetAllVideosHomeSuccess(videos);
    }

    @Override
    public void onFailure(Throwable throwable) {

    }
}
