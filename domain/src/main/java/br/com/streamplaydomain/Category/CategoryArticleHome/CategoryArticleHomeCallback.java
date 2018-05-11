package br.com.streamplaydomain.Category.CategoryArticleHome;

import java.util.List;

import br.com.streamplaydomain.Category.CategoryEntity;

public interface CategoryArticleHomeCallback {

    void onCategorySuccess(List<CategoryEntity> categoryEntity);
    void onFailure(Throwable throwable);

}
