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
//        Call<List<ArticleEntity>> call = service.GetArticleByCategory(category);
//
//        call.enqueue(new Callback<List<ArticleEntity>>() {
//            @Override
//            public void onResponse(Call<List<ArticleEntity>> call, Response<List<ArticleEntity>> response) {
//                if(response.isSuccessful()){
//                    mCallback.onSuccess(response.body());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<ArticleEntity>> call, Throwable t) {
//                mCallback.onFailure(t);
//            }
//        });
    }

    public void setArticleCallback(IArticleCallback callback){
        mCallback = callback;
    }

}
