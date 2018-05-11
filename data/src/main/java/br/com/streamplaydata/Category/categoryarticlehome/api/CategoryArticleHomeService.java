package br.com.streamplaydata.Category.categoryarticlehome.api;

import java.util.List;

import br.com.streamplaydata.Category.CategoryModel;
import br.com.streamplaydata.Category.categoryarticlehome.CategoryArticleHome;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoryArticleHomeService {

    @GET("/categories")
    Call<List<CategoryArticleHome>> getCategories();

}
