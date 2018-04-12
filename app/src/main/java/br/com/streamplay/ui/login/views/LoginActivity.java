package br.com.streamplay.ui.login.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.CallbackManager;

import br.com.streamplay.R;

public class LoginActivity extends AppCompatActivity {

    CallbackManager mCallbackManager = CallbackManager.Factory.create();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        openLoginFragment();
    }

    private void openLoginFragment(){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.framelayout_login, LoginFragment.getInstance())
                .commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);

    }
}
