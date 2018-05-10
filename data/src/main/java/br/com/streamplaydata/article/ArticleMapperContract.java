package br.com.streamplaydata.article;

import java.util.List;

import br.com.streamplaydomain.article.ArticleEntity;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public interface ArticleMapperContract {

    List<ArticleEntity> convertListFromDataToDomain(List<ArticleModel> articleModels);

}
