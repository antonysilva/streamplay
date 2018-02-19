package br.com.streamplay.presenters;

import java.util.List;

import br.com.streamplay.callbacks.IVideoCallback;
import br.com.streamplaydomain.base.Executor;
import br.com.streamplaydomain.base.MainThread;

/**
 * Created by Antony on 09/12/2017.
 */

public class VideoPresenter extends ApplicationPresenter {

    private static VideoPresenter instance;
    private IVideoCallback mCallback;

    public VideoPresenter(Executor executor, MainThread mainThread) {
        super(executor, mainThread);
    }

    public static VideoPresenter getInstance(){
//        if(instance == null)
//            instance = new VideoPresenter();
        return instance;
    }

    public void findByCategory(String category){
//        IVideoService service = getConection().create(IVideoService.class);
//        Call<List<Video>> call = service.GetArticleByCategory(category);
//
//        call.enqueue(new Callback<List<Video>>() {
//            @Override
//            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {
//                if(response.isSuccessful()){
//                    mCallback.onSuccess(response.body());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Video>> call, Throwable t) {
//                mCallback.onFailure(t);
//            }
//        });
    }

    public void setVideoCallback(IVideoCallback callback){
        mCallback = callback;
    }

}
