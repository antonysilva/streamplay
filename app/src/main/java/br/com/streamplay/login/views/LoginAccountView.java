package br.com.streamplay.login.views;

import br.com.streamplaydomain.entities.User;

public interface LoginAccountView {

    void showProgress();
    void hideProgress();

    void onSigninSuccess(User user);
    void onSigninError();

    void onSignupSuccess(User user);
    void onSignupError();

    void onSigninFacebookSuccess();
    void onSigninFacebookError();

}
