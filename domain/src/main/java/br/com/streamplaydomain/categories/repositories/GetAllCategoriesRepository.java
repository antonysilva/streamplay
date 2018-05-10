package br.com.streamplaydomain.categories.repositories;

import java.util.List;

import br.com.streamplaydomain.entities.Category;

public interface GetAllCategoriesRepository {

    void getAllArticles(GetAllCategoriesRepository.Callback callback);

    interface Callback{
        void getAllCategoriesSuccess(List<Category> categories);
    }

}
