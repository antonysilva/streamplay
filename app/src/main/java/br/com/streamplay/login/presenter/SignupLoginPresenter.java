package br.com.streamplay.login.presenter;

import br.com.streamplaydomain.entities.User;

public interface SignupLoginPresenter {

    void onResume();
    void onDestroy();
    void signup(User user);

}
