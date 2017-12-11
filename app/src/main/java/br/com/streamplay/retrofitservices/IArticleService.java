package br.com.streamplay.retrofitservices;

import java.util.List;

import br.com.streamplay.models.Article;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Antony on 10/12/2017.
 */

public interface IArticleService {

    @GET("/articles/category/{category}")
    Call<List<Article>> findByCategory(@Path("category") String category);

}
