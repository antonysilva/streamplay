package br.com.streamplaydata.login.clients;

import android.app.Activity;
import android.content.Context;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import java.util.Arrays;
import java.util.List;

import br.com.streamplaydata.login.callbacks.OnSigninCallback;
import br.com.streamplaydomain.entities.UserAccount;

public class FacebookLoginClient {

    private Activity mActivity;
    private FacebookLoginClient instance;
    private final CallbackManager mCallbackManager = CallbackManager.Factory.create();
    boolean loggedIn = AccessToken.getCurrentAccessToken() == null;
    final List< String > permissionNeeds = Arrays.asList("user_photos", "email",
            "user_birthday", "public_profile", "AccessToken");

    public FacebookLoginClient getInstance(Activity activity) {
        if(instance == null)
            instance = new FacebookLoginClient(activity);

        return instance;
    }

    public FacebookLoginClient(Activity activity){
        mActivity = activity;
    }

    public void execute(final UserAccount userAccount, final OnSigninCallback callback){
        try{
        }catch (Exception ex){}
    }
}
