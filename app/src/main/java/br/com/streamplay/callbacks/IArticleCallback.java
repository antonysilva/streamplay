package br.com.streamplay.callbacks;

import java.util.List;

import br.com.streamplaydomain.article.Article;

/**
 * Created by Antony on 10/12/2017.
 */

public interface IArticleCallback {

    void onSuccess(List<Article> article);
    void onFailure(Throwable t);

}
