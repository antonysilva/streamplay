package br.com.streamplay.callbacks;

import java.util.List;

import br.com.streamplaydomain.article.ArticleEntity;

/**
 * Created by Antony on 10/12/2017.
 */

public interface IArticleCallback {

    void onSuccess(List<ArticleEntity> articleEntity);
    void onFailure(Throwable t);

}
