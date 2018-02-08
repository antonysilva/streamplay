package br.com.streamplaydata.article.client;

import java.util.Iterator;

import br.com.streamplaydata.article.model.Article;

/**
 * Created by Antony Silva on 07/02/2018.
 */

public class ArticleIterator implements Iterator<Article> {

    Article[] articles;
    int position = 0;

    public ArticleIterator(Article[] articles){

    }

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
