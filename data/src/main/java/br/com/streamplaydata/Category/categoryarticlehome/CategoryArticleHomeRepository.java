package br.com.streamplaydata.Category.categoryarticlehome;

import java.util.ArrayList;
import java.util.List;

import br.com.streamplaydata.Category.categoryarticlehome.api.CategoryArticleHomeClient;
import br.com.streamplaydata.Category.categoryarticlehome.api.CategoryArticleHomeClientCallback;
import br.com.streamplaydomain.Category.CategoryArticleHome.CategoryArticleHomeCallback;
import br.com.streamplaydomain.Category.CategoryArticleHome.CategoryArticleHomeRepositoryContract;
import br.com.streamplaydomain.Category.CategoryEntity;

public class CategoryArticleHomeRepository implements CategoryArticleHomeRepositoryContract{

    private static CategoryArticleHomeRepository instance;
    private CategoryArticleHomeCallback mCallback;


    public static CategoryArticleHomeRepository getInstance() {
        if(instance == null)
            instance = new CategoryArticleHomeRepository();
        return instance;
    }

    @Override
    public void getCategory(CategoryArticleHomeCallback callback) {
        mCallback = callback;
        CategoryArticleHomeClient.getInstance().getCategories(new CategoryArticleHomeClientCallback() {
            @Override
            public void onSuccess(List<CategoryArticleHome> categoriesArticleHome) {
                List<CategoryEntity> list = new ArrayList<>();
                for(CategoryArticleHome categoryArticleHome : categoriesArticleHome){
                    list.add(CategoryArticleHomeMaper.convertModelToEntity(categoryArticleHome));
                }
                mCallback.onCategorySuccess(list);
            }

            @Override
            public void onFailure(Throwable throwable) {
                mCallback.onFailure(throwable);
            }
        });
    }
}
