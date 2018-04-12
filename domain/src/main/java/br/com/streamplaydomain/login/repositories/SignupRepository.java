package br.com.streamplaydomain.login.repositories;

import br.com.streamplaydomain.entities.User;
import br.com.streamplaydomain.entities.UserAccount;

public interface SignupRepository {

    User doSignup(User user);

}
