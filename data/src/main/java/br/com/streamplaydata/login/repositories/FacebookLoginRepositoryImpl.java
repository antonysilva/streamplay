package br.com.streamplaydata.login.repositories;

import android.content.Context;

import br.com.streamplaydomain.entities.User;
import br.com.streamplaydomain.login.repositories.FacebookLoginRepository;

public class FacebookLoginRepositoryImpl implements FacebookLoginRepository{

    private FacebookLoginRepositoryImpl instance;
    private Context mContext;

    public FacebookLoginRepositoryImpl getInstance(Context context) {
        if(instance == null)
            instance = new FacebookLoginRepositoryImpl(context);
        return instance;
    }

    public FacebookLoginRepositoryImpl(Context context){
        mContext = context;
    }

    @Override
    public User doSignin() {
        return null;
    }
}
