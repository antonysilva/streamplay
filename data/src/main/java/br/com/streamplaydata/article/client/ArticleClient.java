package br.com.streamplaydata.article.client;

import java.util.List;

import br.com.streamplaydata.base.RetrofitBase;
import br.com.streamplaydata.article.model.Article;
import br.com.streamplaydata.services.ArticleService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public class ArticleClient extends RetrofitBase implements ArticleClientImpl {


    @Override
    public void findByCategory(String category) {
        final ArticleService service = getService(ArticleService.class);
        Call<List<Article>> call = service.findByCategory(category);

        call.enqueue(new Callback<List<Article>>() {
            @Override
            public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {
                if(response.isSuccessful()){
                }
            }

            @Override
            public void onFailure(Call<List<Article>> call, Throwable t) {

            }
        });
    }

    @Override
    public void getAllArticle() {

    }
}
