package br.com.streamplaydata.article.articlehome;

import br.com.streamplaydomain.Article.ArticleEntity;

public class ArticleModelMaper {

    static ArticleEntity convertModelToEntity(ArticleHomeModel model){
        ArticleEntity articleEntity = new ArticleEntity();

        articleEntity.id = model.id;
        articleEntity.author = model.author;
        articleEntity.description = model.description;
        articleEntity.category = model.category;
        articleEntity.title = model.title;
        articleEntity.article_url = model.article_url;
        articleEntity.image = model.image;
        articleEntity.published_at = model.published_at;

        return articleEntity;
    }

}
