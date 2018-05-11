package br.com.streamplay.home.article;

import br.com.streamplay.UIThread;
import br.com.streamplaydata.Category.categoryarticlehome.CategoryArticleHomeRepository;
import br.com.streamplaydomain.Base.ThreadExecutor;
import br.com.streamplaydomain.Category.CategoryArticleHome.CategoryArticleHomeInteractor;

public class CategoryArticleHomeInteractorBuilder {

    static CategoryArticleHomeInteractor create(){
        return new CategoryArticleHomeInteractor(ThreadExecutor.getInstance(), UIThread.getInstance(), new CategoryArticleHomeRepository());
    }

}
