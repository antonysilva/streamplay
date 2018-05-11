package br.com.streamplaydomain.login.interactor.impl;

import br.com.streamplaydomain.Base.AbstractInteractor;
import br.com.streamplaydomain.Base.Executor;
import br.com.streamplaydomain.Base.MainThread;
import br.com.streamplaydomain.entities.User;
import br.com.streamplaydomain.login.interactor.FacebookLoginInteractor;
import br.com.streamplaydomain.login.repositories.FacebookLoginRepository;

public class FacebookLoginInteractorImpl extends AbstractInteractor implements FacebookLoginInteractor{

    FacebookLoginRepository mRepository;
    Callback mCallback;

    public FacebookLoginInteractorImpl(Executor threadExecutor, MainThread mainThread,
                                       FacebookLoginRepository repository, Callback callback) {
        super(threadExecutor, mainThread);

        mRepository = repository;
        mCallback = callback;
    }

    @Override
    public void run() {

    }

    @Override
    public void onSuccess() {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onFacebookLoginSuccess(new User());
            }
        });
    }

    @Override
    public void onError() {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onFacebookLoginError();
            }
        });
    }
}
