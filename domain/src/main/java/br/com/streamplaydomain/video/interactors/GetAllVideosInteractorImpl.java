package br.com.streamplaydomain.video.interactors;

import java.util.ArrayList;
import java.util.List;

import br.com.streamplaydomain.base.AbstractInteractor;
import br.com.streamplaydomain.base.Executor;
import br.com.streamplaydomain.base.MainThread;
import br.com.streamplaydomain.entities.Video;
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
        mRepository.getAllVideos(new GetAllVideosRepository.Callback() {
            @Override
            public void getAllVideoSuccess(List<Video> videos) {
                mVideos = videos;
                if(mVideos.isEmpty())
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
                mCallback.getAllVideoSuccess(mVideos);
            }
        });
    }

    @Override
    public void onError() {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.getAllVideoSuccess(new ArrayList<>());
            }
        });
    }


}
