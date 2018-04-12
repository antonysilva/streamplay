package br.com.streamplaydata.login.repositories;

import android.content.Context;

import br.com.streamplaydata.login.callbacks.OnSigninCallback;
import br.com.streamplaydata.login.clients.SigninClient;
import br.com.streamplaydomain.entities.User;
import br.com.streamplaydomain.entities.UserAccount;
import br.com.streamplaydomain.login.repositories.SigninRepository;

public class SigninRepositoryImpl implements SigninRepository{

    private SigninRepositoryImpl instance;
    private Context mContext;
    private User mUser;

    public SigninRepositoryImpl getInstance(Context context) {
        if(instance == null)
            instance = new SigninRepositoryImpl(context);
        return instance;
    }

    public SigninRepositoryImpl(Context context){
        mContext = context;
    }

    @Override
    public User doSigin(UserAccount userAccount) {
        SigninClient.getInstance(mContext).execute(userAccount, new OnSigninCallback() {
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
