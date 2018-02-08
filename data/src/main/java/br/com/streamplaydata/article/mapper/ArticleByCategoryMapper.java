package br.com.streamplaydata.article.mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.streamplaydata.article.client.ArticleIterator;
import br.com.streamplaydata.article.model.Article;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public class ArticleByCategoryMapper implements ArticleByCategoryMapperImpl {

    @Override
    public List<Article> convert(Article[] articles) {
        List<Article> articleList = new ArrayList<>();
        Iterator articleInterator = new ArticleIterator(articles);

        while(articleInterator.hasNext()){
            Article article = (Article) articleInterator.next();

            int id = article.getId();
            String author = article.getAuthor();
            String category = article.getCategory();
            String title = article.getTitle();
            String description = article.getDescription();
            String image = article.getImage();
            String article_url = article.getArticle_url();
            String published_at = article.getPublished_at();

            articleList.add(new Article(id, author, category, title, description, image, article_url, published_at));
        }

        return articleList;
    }
}
