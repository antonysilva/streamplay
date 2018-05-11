package br.com.streamplay.home.article;

import br.com.streamplay.UIThread;
import br.com.streamplaydata.article.articlehome.ArticlesHomeRepository;
import br.com.streamplaydomain.Article.GetArticleHome.ArticlesHomeInteractor;
import br.com.streamplaydomain.Base.ThreadExecutor;

public class ArticleHomeInteractorBuilder {

    static ArticlesHomeInteractor create(){
        return new ArticlesHomeInteractor(ThreadExecutor.getInstance(), UIThread.getInstance(),
                ArticlesHomeRepository.getInstance());
    }

}
