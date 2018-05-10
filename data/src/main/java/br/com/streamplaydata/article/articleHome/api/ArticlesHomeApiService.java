package br.com.streamplaydata.article.articleHome.api;

import java.util.List;

import br.com.streamplaydata.article.articleHome.ArticleHomeModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ArticlesHomeApiService {

    @GET("/articles")
    Call<List<ArticleHomeModel>> getArticles();

}
