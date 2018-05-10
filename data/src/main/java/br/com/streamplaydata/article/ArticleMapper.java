package br.com.streamplaydata.article;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.streamplaydomain.article.ArticleEntity;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public class ArticleMapper implements ArticleMapperContract {

    private static ArticleMapper instance;

    public static ArticleMapper getInstance() {
        if (instance == null)
            instance = new ArticleMapper();
        return instance;
    }

    @Override
    public List<ArticleEntity> convertListFromDataToDomain(List<ArticleModel> articles) {
        List<ArticleEntity> articleEntityList = new ArrayList<>();
        Iterator articleInterator = new ArticleIterator(articles);

        while(articleInterator.hasNext()){
            ArticleModel article = (ArticleModel) articleInterator.next();

            int id = article.getId();
            String author = article.getAuthor();
            String category = article.getCategory();
            String title = article.getTitle();
            String description = article.getDescription();
            String image = article.getImage();
            String article_url = article.getArticle_url();
            String published_at = article.getPublished_at();

            articleEntityList.add(new ArticleEntity(id, author, category, title, description, image, article_url, published_at));
        }

        return articleEntityList;
    }
}
