package br.com.streamplaydomain.categories.interactors;

import java.util.List;

import br.com.streamplaydomain.base.Interactor;
import br.com.streamplaydomain.entities.Category;

public interface GetAllCategoriesInteractor extends Interactor {
    void onSuccess();
    void onError();

    interface Callback{
        void gettAllCategoriesSuccess(List<Category> categories);
    }
}
