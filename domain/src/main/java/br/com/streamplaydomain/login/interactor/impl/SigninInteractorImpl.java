package br.com.streamplaydomain.login.interactor.impl;

import br.com.streamplaydomain.Base.AbstractInteractor;
import br.com.streamplaydomain.Base.Executor;
import br.com.streamplaydomain.Base.MainThread;
import br.com.streamplaydomain.entities.User;
import br.com.streamplaydomain.entities.UserAccount;
import br.com.streamplaydomain.login.interactor.SigninInteractor;
import br.com.streamplaydomain.login.repositories.SigninRepository;

public class SigninInteractorImpl extends AbstractInteractor implements SigninInteractor{

    Callback mCallback;
    SigninRepository mRepository;
    UserAccount mUserAccount;

    public SigninInteractorImpl(Executor threadExecutor, MainThread mainThread,
                                SigninRepository repository, Callback callback,
                                UserAccount userAccount) {
        super(threadExecutor, mainThread);

        mCallback = callback;
        mRepository = repository;
        mUserAccount = userAccount;
    }

    @Override
    public void run() {

    }

    @Override
    public void onSuccess() {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onSignInSuccess(new User());
            }
        });
    }

    @Override
    public void onError() {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onSignInError();
            }
        });
    }
}
