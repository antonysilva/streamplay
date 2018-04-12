package br.com.streamplay.ui.login.presenter;

import br.com.streamplaydomain.entities.UserAccount;

public interface SigninLoginPresenter {

    void onResume();
    void onDestroy();
    void signin(UserAccount userAccount);

}
