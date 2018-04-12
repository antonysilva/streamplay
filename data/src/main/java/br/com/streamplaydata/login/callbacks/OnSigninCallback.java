package br.com.streamplaydata.login.callbacks;

import br.com.streamplaydomain.entities.User;

public interface OnSigninCallback {

    void onSuccess(User user);
    void onError();


}

