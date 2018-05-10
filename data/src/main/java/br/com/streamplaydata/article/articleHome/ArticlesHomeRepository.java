package br.com.streamplaydata.article.articleHome;

import java.util.ArrayList;
import java.util.List;

import br.com.streamplaydata.article.ArticleMapper;
import br.com.streamplaydata.article.articleHome.api.ArticlesHomeClient;
import br.com.streamplaydata.article.articleHome.api.ArticlesHomeClientCallback;
import br.com.streamplaydomain.article.ArticleEntity;
import br.com.streamplaydomain.article.articlesHome.ArticlesHomeCallback;
import br.com.streamplaydomain.article.repositories.ArticleRepositoryContract;
import br.com.streamplaydomain.video.VideoEntity;

public class ArticlesHomeRepository implements ArticleRepositoryContract{

    private static ArticlesHomeRepository instance;

    private ArticlesHomeCallback mCallback;

    public static ArticlesHomeRepository getInstance() {
        if(instance == null)
            instance = new ArticlesHomeRepository();
        return instance;
    }

    @Override
    public void getAll(ArticlesHomeCallback callback) {
        mCallback = callback;
        ArticlesHomeClient.getInstance().getArticles(new ArticlesHomeClientCallback() {
            @Override
            public void onSuccess(List<ArticleHomeModel> articles) {
                List<ArticleEntity> list = new ArrayList<>();
                for (ArticleHomeModel item : articles){
                    list.add(ArticleModelMaper.convertModelToEntity(item));
                }
                mCallback.onSuccess(list);
            }

            @Override
            public void onFailure(Throwable throwable) {
                mCallback.onFailure(throwable);
            }
        });
    }
}
