package br.com.streamplaydata.article.articlehome;

import java.util.ArrayList;
import java.util.List;

import br.com.streamplaydata.article.articlehome.api.ArticlesHomeClient;
import br.com.streamplaydata.article.articlehome.api.ArticlesHomeClientCallback;
import br.com.streamplaydomain.Article.ArticleEntity;
import br.com.streamplaydomain.Article.GetArticleHome.ArticlesHomeCallback;
import br.com.streamplaydomain.Article.GetArticleHome.ArticlesHomeRepositoryContract;

public class ArticlesHomeRepository implements ArticlesHomeRepositoryContract{

    private static ArticlesHomeRepository instance;

    private ArticlesHomeCallback mCallback;

    public static ArticlesHomeRepository getInstance() {
        if(instance == null)
            instance = new ArticlesHomeRepository();
        return instance;
    }

    @Override
    public void getArticlesHome(ArticlesHomeCallback callback) {
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
