package br.com.streamplaydata.article.mapper;

import java.util.List;

import br.com.streamplaydata.article.model.ArticleModel;
import br.com.streamplaydomain.article.Article;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public interface ArticleMapperContract {

    List<Article> convertListFromDataToDomain(ArticleModel[] articleModels);

}
