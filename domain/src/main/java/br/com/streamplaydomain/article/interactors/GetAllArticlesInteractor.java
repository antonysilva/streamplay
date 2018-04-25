package br.com.streamplaydomain.article.interactors;

import java.util.List;

import br.com.streamplaydomain.entities.Article;

public interface GetAllArticlesInteractor {
    void onSuccess();
    void onError();

    interface Callback{
        void getAllArticlesSuccess(List<Article> videos);
    }
}
