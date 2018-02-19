package br.com.streamplaydomain.article.calbacks;

import br.com.streamplaydomain.briefing.models.Briefing;

/**
 * Created by Antony Silva on 09/02/2018.
 */

public interface GetArticleByCategory {

    void onGetArticleByCategorySuccess(Briefing briefing);
    void onError(Throwable throwable);


}
