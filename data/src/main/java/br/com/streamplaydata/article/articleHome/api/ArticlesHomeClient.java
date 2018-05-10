package br.com.streamplaydata.article.articleHome.api;

import java.util.List;

import br.com.streamplaydata.article.ArticleModel;
import br.com.streamplaydata.article.ArticleService;
import br.com.streamplaydata.article.api.ArticleClient;
import br.com.streamplaydata.article.articleHome.ArticleHomeModel;
import br.com.streamplaydata.base.RetrofitBase;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticlesHomeClient extends RetrofitBase{

    private static ArticlesHomeClient instance;

    public static ArticlesHomeClient getInstance() {
        if (instance == null)
            instance = new ArticlesHomeClient();
        return instance;
    }

    public void getArticles(final ArticlesHomeClientCallback callback) {
        final ArticlesHomeApiService service = getService(ArticlesHomeApiService.class);
        Call<List<ArticleHomeModel>> call = service.getArticles();

        call.enqueue(new Callback<List<ArticleHomeModel>>() {
            @Override
            public void onResponse(Call<List<ArticleHomeModel>> call, Response<List<ArticleHomeModel>> response) {
                if(response.isSuccessful()){
                    callback.onSuccess(response.body());
                }else { callback.onFailure(new Throwable()); }
            }

            @Override
            public void onFailure(Call<List<ArticleHomeModel>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

}
