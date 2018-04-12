package br.com.streamplaydomain.login.interactor;

import br.com.streamplaydomain.base.Interactor;
import br.com.streamplaydomain.entities.User;

public interface FacebookLoginInteractor extends Interactor {

    void onSuccess();
    void onError();

    interface Callback{
        void onFacebookLoginSuccess(User user);
        void onFacebookLoginError();
    }

}
