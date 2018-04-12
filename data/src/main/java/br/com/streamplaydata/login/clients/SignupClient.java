package br.com.streamplaydata.login.clients;

import android.content.Context;

import br.com.streamplaydata.login.callbacks.OnSignupCallback;
import br.com.streamplaydomain.entities.User;

public class SignupClient {

    private static SignupClient instance;
    private Context mContext;

    public static SignupClient getInstance(Context context) {
        if(instance == null)
            instance = new SignupClient(context);
        return instance;
    }

    public SignupClient(Context context){
        mContext = context;
    }


    public void execute(final User user, final OnSignupCallback callback){
        try{

        }catch (Exception ex){}
    }

}
