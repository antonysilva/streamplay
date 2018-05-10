package br.com.streamplaydata.article.api;

import br.com.streamplaydata.article.api.callbacks.GetAllArticleCallback;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public interface ArticleClientContract {

    void findByCategory(String category);
    void getAllArticle(GetAllArticleCallback callback);

}
