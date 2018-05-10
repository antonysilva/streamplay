package br.com.streamplaydomain.article.repositories;

import br.com.streamplaydomain.article.articlesHome.ArticlesHomeCallback;

/**
 * Created by Antony Silva on 09/02/2018.
 */

public interface ArticleRepositoryContract {
    void getAll(ArticlesHomeCallback callback);

}
