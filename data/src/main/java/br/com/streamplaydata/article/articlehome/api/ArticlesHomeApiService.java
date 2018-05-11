package br.com.streamplaydata.article.articlehome.api;

import java.util.List;

import br.com.streamplaydata.article.articlehome.ArticleHomeModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ArticlesHomeApiService {

    @GET("/articles")
    Call<List<ArticleHomeModel>> getArticles();

}
