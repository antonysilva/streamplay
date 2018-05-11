package br.com.streamplaydata.Category.categoryarticlehome.api;

import java.util.List;

import br.com.streamplaydata.Category.categoryarticlehome.CategoryArticleHome;

public interface CategoryArticleHomeClientCallback {

    void onSuccess(List<CategoryArticleHome> categoriesArticleHome);
    void onFailure(Throwable throwable);


}
