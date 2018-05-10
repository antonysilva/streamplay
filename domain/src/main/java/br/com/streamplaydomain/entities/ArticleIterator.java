package br.com.streamplaydomain.entities;

import java.util.Iterator;

import br.com.streamplaydomain.article.ArticleEntity;

/**
 * Created by Antony Silva on 07/02/2018.
 */

public class ArticleIterator implements Iterator<ArticleEntity> {

    ArticleEntity[] articleEntities;
    int position = 0;

    @Override
    public boolean hasNext() {
        if(position >= articleEntities.length || articleEntities[position] == null){
            return false;
        }else { return true; }
    }

    @Override
    public ArticleEntity next() {
        ArticleEntity articleEntity = articleEntities[position];
        position++;
        return articleEntity;
    }
}
