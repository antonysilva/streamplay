package br.com.streamplaydomain.categories.repositories;

import java.util.List;

import br.com.streamplaydomain.entities.Article;
import br.com.streamplaydomain.entities.Category;
import br.com.streamplaydomain.entities.Video;
import br.com.streamplaydomain.video.repositories.GetAllVideosRepository;

public interface GetAllCategoriesRepository {

    void getAllArticles(GetAllCategoriesRepository.Callback callback);

    interface Callback{
        void getAllCategoriesSuccess(List<Category> categories);
    }

}
