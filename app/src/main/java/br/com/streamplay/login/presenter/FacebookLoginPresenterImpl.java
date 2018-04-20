package br.com.streamplay.login.presenter;

import br.com.streamplay.login.views.LoginAccountView;
import br.com.streamplay.presenters.ApplicationPresenter;
import br.com.streamplaydomain.base.Executor;
import br.com.streamplaydomain.base.MainThread;
import br.com.streamplaydomain.login.repositories.FacebookLoginRepository;

public class FacebookLoginPresenterImpl extends ApplicationPresenter {

    LoginAccountView mView;
    FacebookLoginRepository mRepository;

    public FacebookLoginPresenterImpl(Executor executor, MainThread mainThread,
                                      LoginAccountView view, FacebookLoginRepository repository) {
        super(executor, mainThread);

        mView = view;
        mRepository = repository;
    }

    public void doLogin(){

    }

}
