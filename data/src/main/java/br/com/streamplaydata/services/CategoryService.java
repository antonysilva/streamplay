package br.com.streamplaydata.services;

import java.util.List;

import br.com.streamplaydata.models.CategoryModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoryService {

    @GET("/categories")
    Call<List<CategoryModel>> getAll();

}
