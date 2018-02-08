package br.com.streamplaydata.article.model;

import java.util.Iterator;

import br.com.streamplaydata.article.model.ArticleModel;

/**
 * Created by Antony Silva on 07/02/2018.
 */

public class ArticleIterator implements Iterator<ArticleModel> {

    ArticleModel[] articleModels;
    int position = 0;

    public ArticleIterator(ArticleModel[] articleModels){
        this.articleModels = articleModels;
    }

    @Override
    public boolean hasNext() {
        if(position >= this.articleModels.length || this.articleModels[position] == null){
            return false;
        }else { return true; }
    }

    @Override
    public ArticleModel next() {
        ArticleModel articleModel = this.articleModels[position];
        position++;
        return articleModel;
    }
}
