package br.com.streamplaydata.article.api;

import java.util.List;

import br.com.streamplaydata.article.ArticleModel;
import br.com.streamplaydata.article.api.callbacks.GetAllArticleCallback;
import br.com.streamplaydata.article.ArticleMapper;
import br.com.streamplaydata.article.ArticleService;
import br.com.streamplaydata.base.RetrofitBase;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public class ArticleClient extends RetrofitBase implements ArticleClientContract {

    private static ArticleClient instance;

    public static ArticleClient getInstance() {
        if (instance == null)
            instance = new ArticleClient();
        return instance;
    }

    @Override
    public void findByCategory(String category) {
        final ArticleService service = getService(ArticleService.class);
        Call<List<ArticleModel>> call = service.findByCategory(category);

        call.enqueue(new Callback<List<ArticleModel>>() {
            @Override
            public void onResponse(Call<List<ArticleModel>> call, Response<List<ArticleModel>> response) {
                if(response.isSuccessful()){

                }
            }

            @Override
            public void onFailure(Call<List<ArticleModel>> call, Throwable t) {

            }
        });
    }

    @Override
    public void getAllArticle(final GetAllArticleCallback callback) {
        final ArticleService service = getService(ArticleService.class);
        Call<List<ArticleModel>> call = service.findAll();

        call.enqueue(new Callback<List<ArticleModel>>() {
            @Override
            public void onResponse(Call<List<ArticleModel>> call, Response<List<ArticleModel>> response) {
                if(response.isSuccessful()){
                    try{
                        callback.onSuccess(ArticleMapper.getInstance().convertListFromDataToDomain(response.body()));
                    }catch (Exception ex){ callback.onError(); }
                }
            }

            @Override
            public void onFailure(Call<List<ArticleModel>> call, Throwable t) {
                callback.onError();
            }
        });
    }
}
