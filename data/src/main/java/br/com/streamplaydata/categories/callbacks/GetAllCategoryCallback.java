package br.com.streamplaydata.categories.callbacks;

import java.util.List;

import br.com.streamplaydomain.entities.Category;

public interface GetAllCategoryCallback {

    void onSuccess(List<Category> categories);
    void onError();

}
