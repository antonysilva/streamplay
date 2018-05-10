package br.com.streamplaydata.article;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Antony Silva on 07/02/2018.
 */

public class ArticleIterator implements Iterator<ArticleModel> {

    List<ArticleModel> articleModels;
    int position = 0;

    public ArticleIterator(List<ArticleModel> articleModels){
        this.articleModels = articleModels;
    }

    @Override
    public boolean hasNext() {
        if(position >= this.articleModels.size() || this.articleModels.get(position) == null){
            return false;
        }else { return true; }
    }

    @Override
    public ArticleModel next() {
        ArticleModel articleModel = this.articleModels.get(position);
        position++;
        return articleModel;
    }
}
