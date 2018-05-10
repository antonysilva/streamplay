package br.com.streamplaydomain.video.GetAllVideos;

import java.util.List;

import br.com.streamplaydomain.base.AbstractInteractor;
import br.com.streamplaydomain.base.Executor;
import br.com.streamplaydomain.base.MainThread;
import br.com.streamplaydomain.video.VideoEntity;

public class GetAllVideosInteractor extends AbstractInteractor implements GetAllVideosCallback{

    GetAllVideosCallback mCallback;
    List<VideoEntity> mVideos;
    GetAllVideosRepository mRepository;
    GetAllVideosCallback mVideoCallback;

    public GetAllVideosInteractor(Executor threadExecutor, MainThread mainThread,
                                  GetAllVideosRepository repository) {
        super(threadExecutor, mainThread);

        mRepository = repository;
    }

    public void getAllVideos(GetAllVideosCallback callback){
        mVideoCallback = callback;
        mThreadExecutor.execute(this);
    }

    @Override
    public void run() {
        mRepository.getAllVideos(mVideoCallback);
    }

    @Override
    public void onSuccess(List<VideoEntity> videos) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onSuccess(mVideos);
            }
        });
    }

    @Override
    public void onFailure(Throwable throwable) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onFailure(new Throwable());
            }
        });
    }
}
