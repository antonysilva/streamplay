package br.com.streamplay.login.presenter;

import br.com.streamplay.presenters.ApplicationPresenter;
import br.com.streamplaydomain.base.Executor;
import br.com.streamplaydomain.base.MainThread;

public class SignupLoginPresenterImpl extends ApplicationPresenter {

    public SignupLoginPresenterImpl(Executor executor, MainThread mainThread) {
        super(executor, mainThread);
    }

}
