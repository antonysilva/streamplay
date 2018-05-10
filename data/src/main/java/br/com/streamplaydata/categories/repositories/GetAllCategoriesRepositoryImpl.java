package br.com.streamplaydata.categories.repositories;

import java.util.ArrayList;
import java.util.List;

import br.com.streamplaydata.categories.callbacks.GetAllCategoryCallback;
import br.com.streamplaydata.categories.clients.GetAllCategoryClient;
import br.com.streamplaydomain.categories.repositories.GetAllCategoriesRepository;
import br.com.streamplaydomain.entities.Category;

public class GetAllCategoriesRepositoryImpl implements GetAllCategoriesRepository {

    private static GetAllCategoriesRepositoryImpl instance;

    public static GetAllCategoriesRepositoryImpl getInstance() {
        if (instance == null)
            instance = new GetAllCategoriesRepositoryImpl();
        return instance;
    }

    public GetAllCategoriesRepositoryImpl(){
    }

    @Override
    public void getAllArticles(final Callback callback) {
        GetAllCategoryClient.getInstance().execute(new GetAllCategoryCallback() {
            @Override
            public void onSuccess(List<Category> categories) {
                callback.getAllCategoriesSuccess(categories);
            }

            @Override
            public void onError() {
                callback.getAllCategoriesSuccess(new ArrayList<Category>());
            }
        });
    }
}
