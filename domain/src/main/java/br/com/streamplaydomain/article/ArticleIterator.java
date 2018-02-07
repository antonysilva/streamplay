package br.com.streamplaydomain.article;

import java.util.Iterator;

/**
 * Created by Antony Silva on 07/02/2018.
 */

public class ArticleIterator implements Iterator<Article> {

    Article[] articles;
    int position = 0;

    @Override
    public boolean hasNext() {
        if(position >= articles.length || articles[position] == null){
            return false;
        }else { return true; }
    }

    @Override
    public Article next() {
        Article article = articles[position];
        position++;
        return article;
    }
}
