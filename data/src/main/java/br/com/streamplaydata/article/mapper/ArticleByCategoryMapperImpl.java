package br.com.streamplaydata.article.mapper;

import java.util.List;

import br.com.streamplaydata.article.model.Article;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public interface ArticleByCategoryMapperImpl {

    List<Article> convert(Article[] articles);

}
