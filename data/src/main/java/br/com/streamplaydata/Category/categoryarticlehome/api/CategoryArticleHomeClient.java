package br.com.streamplaydata.Category.categoryarticlehome.api;

import java.util.List;

import br.com.streamplaydata.Category.categoryarticlehome.CategoryArticleHome;
import br.com.streamplaydata.base.RetrofitBase;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryArticleHomeClient extends RetrofitBase{

    private static CategoryArticleHomeClient instance;

    public static CategoryArticleHomeClient getInstance() {
        if(instance == null)
            instance = new CategoryArticleHomeClient();
        return instance;
    }

    public void getCategories(final CategoryArticleHomeClientCallback callback){
        final CategoryArticleHomeService service = getService(CategoryArticleHomeService.class);
        Call<List<CategoryArticleHome>> call = service.getCategories();

        call.enqueue(new Callback<List<CategoryArticleHome>>() {
            @Override
            public void onResponse(Call<List<CategoryArticleHome>> call, Response<List<CategoryArticleHome>> response) {
                if(response.isSuccessful()){
                    callback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<CategoryArticleHome>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }
}
