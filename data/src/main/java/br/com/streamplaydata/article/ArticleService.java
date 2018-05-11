package br.com.streamplaydata.article;

import java.util.List;

import br.com.streamplaydata.article.articlehome.ArticleHomeModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Antony on 10/12/2017.
 */

public interface ArticleService {

    @GET("/articles")
    Call<List<ArticleHomeModel>> findAll();

    @GET("/articles/category/{category}")
    Call<List<ArticleHomeModel>> findByCategory(@Path("category") String category);

}
