package br.com.streamplaydata.models.mappers;

import java.util.Iterator;
import java.util.List;

import br.com.streamplaydata.models.CategoryModel;
import br.com.streamplaydata.models.VideoModel;

public class CategoryIterator implements Iterator<CategoryModel> {

    private List<CategoryModel> categoryModels;
    private int position = 0;

    public CategoryIterator(List<CategoryModel> categoryModels){
        this.categoryModels = categoryModels;
    }

    @Override
    public boolean hasNext() {
        if(position >= this.categoryModels.size() || this.categoryModels.get(position) == null){
            return false;
        }else { return true; }
    }

    @Override
    public CategoryModel next() {
        CategoryModel categoryModel = this.categoryModels.get(position);
        position++;
        return categoryModel;
    }

}
