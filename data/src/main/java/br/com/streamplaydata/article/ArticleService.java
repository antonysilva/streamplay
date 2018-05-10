package br.com.streamplaydata.article;

import java.util.List;

import br.com.streamplaydata.article.ArticleModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Antony on 10/12/2017.
 */

public interface ArticleService {

    @GET("/articles")
    Call<List<ArticleModel>> findAll();

    @GET("/articles/category/{category}")
    Call<List<ArticleModel>> findByCategory(@Path("category") String category);

}
