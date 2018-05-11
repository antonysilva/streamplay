package br.com.streamplaydomain.Video.GetAllVideos;

import java.util.List;

import br.com.streamplaydomain.Base.AbstractInteractor;
import br.com.streamplaydomain.Base.Executor;
import br.com.streamplaydomain.Base.MainThread;
import br.com.streamplaydomain.Video.VideoEntity;

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
