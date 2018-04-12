package br.com.streamplaydata.login.clients;

import android.content.Context;

import br.com.streamplaydata.login.callbacks.OnSigninCallback;
import br.com.streamplaydomain.entities.UserAccount;

public class SigninClient {

    private static SigninClient instance;
    private Context mContext;

    public static SigninClient getInstance(Context context) {
        if(instance == null)
            instance = new SigninClient(context);
        return instance;
    }

    public SigninClient(Context context){
        mContext = context;
    }


    public void execute(final UserAccount userAccount, final OnSigninCallback callback){
        try{

        }catch (Exception ex){}
    }
}
