package br.com.streamplaydata.login.repositories;

import android.content.Context;

import br.com.streamplaydata.login.callbacks.OnSignupCallback;
import br.com.streamplaydata.login.clients.SignupClient;
import br.com.streamplaydomain.entities.User;
import br.com.streamplaydomain.login.repositories.SignupRepository;

public class SignupRepositoryImpl implements SignupRepository {

    private static SignupRepositoryImpl instance;
    private Context mContext;
    private User mUser;

    public static SignupRepositoryImpl getInstance(Context context) {
        if(instance == null)
            instance = new SignupRepositoryImpl(context);
        return instance;
    }

    public SignupRepositoryImpl(Context context){
        mContext = context;
    }

    @Override
    public User doSignup(User user) {
        SignupClient.getInstance(mContext).execute(user, new OnSignupCallback() {
            @Override
            public void onSuccess(User user) {
                mUser = user;
            }

            @Override
            public void onError() {
                mUser = new User();
            }
        });
        return mUser;
    }
}
