package br.com.streamplaydomain.login.interactor;

import br.com.streamplaydomain.base.Interactor;
import br.com.streamplaydomain.entities.User;

public interface SigninInteractor extends Interactor{

    void onSuccess();
    void onError();

    interface Callback{
        void onSignInSuccess(User user);
        void onSignInError();
    }


}
