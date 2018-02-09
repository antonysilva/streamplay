package br.com.streamplay.presenters;

import java.util.List;

import br.com.streamplay.callbacks.IArticleCallback;
import br.com.streamplaydomain.base.Executor;
import br.com.streamplaydomain.base.MainThread;

/**
 * Created by Antony on 09/12/2017.
 */

public class ArticlePresenter extends ApplicationPresenter {

    private static ArticlePresenter instance;
    private IArticleCallback mCallback;

    public ArticlePresenter(Executor executor, MainThread mainThread) {
        super(executor, mainThread);
    }

    public static ArticlePresenter getInstance(){
//        if(instance == null)
//            instance = new ArticlePresenter();
        return instance;
    }

    public void findByCategory(String category){
//        IArticleService service = getConection().create(IArticleService.class);
//        Call<List<Article>> call = service.findByCategory(category);
//
//        call.enqueue(new Callback<List<Article>>() {
//            @Override
//            public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {
//                if(response.isSuccessful()){
//                    mCallback.onSuccess(response.body());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Article>> call, Throwable t) {
//                mCallback.onFailure(t);
//            }
//        });
    }

    public void setArticleCallback(IArticleCallback callback){
        mCallback = callback;
    }

}
