package br.com.streamplaydata.Category.categoryarticlehome;

import br.com.streamplaydomain.Category.CategoryEntity;

public class CategoryArticleHomeMaper {

    static CategoryEntity convertModelToEntity(CategoryArticleHome model){
        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.id = model.id;
        categoryEntity.code = model.code;
        categoryEntity.name = model.name;

        return categoryEntity;
    }

}
