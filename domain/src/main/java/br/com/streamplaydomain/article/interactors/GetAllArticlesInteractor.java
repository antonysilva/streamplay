package br.com.streamplaydomain.article.interactors;

import java.util.List;

import br.com.streamplaydomain.article.ArticleEntity;

public interface GetAllArticlesInteractor {
    void onSuccess();
    void onError();

    interface Callback{
        void getAllArticlesSuccess(List<ArticleEntity> videos);
    }
}
