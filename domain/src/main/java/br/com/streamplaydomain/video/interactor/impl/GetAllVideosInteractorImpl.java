package br.com.streamplaydomain.video.interactor.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.streamplaydomain.base.AbstractInteractor;
import br.com.streamplaydomain.base.Executor;
import br.com.streamplaydomain.base.MainThread;
import br.com.streamplaydomain.entities.Video;
import br.com.streamplaydomain.video.interactor.GetAllVideosInteractor;
import br.com.streamplaydomain.video.repositories.GetAllVideosRepository;

public class GetAllVideosInteractorImpl extends AbstractInteractor implements GetAllVideosInteractor{

    Callback mCallback;
    List<Video> mVideos;
    GetAllVideosRepository mRepository;

    public GetAllVideosInteractorImpl(Executor threadExecutor, MainThread mainThread,
                                      GetAllVideosRepository repository, Callback callback) {
        super(threadExecutor, mainThread);

        mCallback = callback;
        mRepository = repository;
    }

    @Override
    public void run() {
        mVideos = mRepository.getAllVideos();

        if(!(mVideos = mRepository.getAllVideos()).isEmpty())
            onSuccess();
        onError();
    }

    @Override
    public void onSuccess() {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.getAllVideosCallback(mVideos);
            }
        });
    }

    @Override
    public void onError() {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.getAllVideosCallback(new ArrayList<>());
            }
        });
    }

}