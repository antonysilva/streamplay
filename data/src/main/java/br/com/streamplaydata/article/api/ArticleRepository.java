package br.com.streamplaydata.article.api;

import java.util.List;

import br.com.streamplaydata.article.api.callbacks.GetAllArticleCallback;
import br.com.streamplaydomain.article.repositories.ArticleRepositoryContract;
import br.com.streamplaydomain.article.ArticleEntity;

public class ArticleRepository implements ArticleRepositoryContract{



    @Override
    public void getArticleByCategory(String category) {

    }

    @Override
    public void getAll() {
        ArticleClient.getInstance().getAllArticle(new GetAllArticleCallback() {
            @Override
            public void onSuccess(List<ArticleEntity> articleEntities) {

            }

            @Override
            public void onError() {

            }
        });
    }
}
