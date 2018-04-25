package br.com.streamplay.category.presenters;

import java.util.List;

import br.com.streamplaydomain.entities.Category;

public interface GetAllCategoriesHomePresenter {

    void getAllCategoriesHome();

    interface View{
        void onGetAllCategoriesHomeSuccess(List<Category> categories);
    }

}
