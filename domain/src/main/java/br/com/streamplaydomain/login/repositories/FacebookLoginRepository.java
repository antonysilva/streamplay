package br.com.streamplaydomain.login.repositories;

import br.com.streamplaydomain.entities.User;

public interface FacebookLoginRepository {

    User doSignin();

}
