package br.com.streamplaydata.models.mappers;

import java.util.ArrayList;
import java.util.List;

import br.com.streamplaydata.models.CategoryModel;
import br.com.streamplaydomain.entities.Category;
import br.com.streamplaydomain.video.VideoEntity;

public class CategoryModelMapper {

    private static CategoryModelMapper instance;

    public static CategoryModelMapper getInstance() {
        if(instance == null)
            instance = new CategoryModelMapper();
        return instance;
    }

    public VideoEntity convert(CategoryModel categoryModel){
        return null;
    }

    public List<Category> convert(List<CategoryModel> categoryModel){
        List<Category> categories = new ArrayList<>();
        try{
            CategoryIterator categoryIterator = new CategoryIterator(categoryModel);
            while (categoryIterator.hasNext()){
                CategoryModel vMode1 = categoryIterator.next();

                Integer      id = vMode1.getId();
                String       name = vMode1.getName();
                String       code = vMode1.getCode();

                categories.add(new Category(id, name, code));
            }
        }catch (Exception ex){
        }

        return categories;
    }

}
