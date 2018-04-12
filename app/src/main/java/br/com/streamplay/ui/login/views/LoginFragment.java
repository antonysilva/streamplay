package br.com.streamplay.ui.login.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.yqritc.scalablevideoview.ScalableVideoView;

import br.com.streamplay.R;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private static LoginFragment instance;
    private ScalableVideoView mVideoviewLogin;
    private Button mSigninButton;
    private Button mSignupButton;
    private ImageView mImageViewSiginBack;
    private ImageView mImageViewSigoutBack;
    private View mSigninView;
    private View mSignupView;
    private View mViewButtons;

    public static LoginFragment getInstance() {
        if(instance == null)
            instance = new LoginFragment();
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        mVideoviewLogin = (ScalableVideoView) view.findViewById(R.id.videoview_splashscreem);
        mSigninButton = (Button) view.findViewById(R.id.btn_signin);
        mSignupButton = (Button) view.findViewById(R.id.btn_signup);
        mImageViewSiginBack = (ImageView) view.findViewById(R.id.image_back_button_signin);
        mImageViewSigoutBack = (ImageView) view.findViewById(R.id.image_back_button_signup);
        mSigninView = (View) view.findViewById(R.id.view_signin);
        mSignupView = (View) view.findViewById(R.id.view_signup);
        mViewButtons = (View) view.findViewById(R.id.view_buttons);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        mSigninButton.setOnClickListener(this);
        mSignupButton.setOnClickListener(this);
        mImageViewSiginBack.setOnClickListener(this);
        mImageViewSigoutBack.setOnClickListener(this);
        startOpennedVideo();
    }

    protected void startOpennedVideo(){
        try{
            Uri path = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.raw.party);
            mVideoviewLogin.setDataSource(getContext(), path);
            mVideoviewLogin.prepareAsync(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mVideoviewLogin.setLooping(true);
                    mVideoviewLogin.start();
                }
            });
        }catch (Exception ex){ }
    }

    protected void fadeViewToggle(final View currentView, final View nextView){
        nextView.setVisibility(View.VISIBLE);
        nextView.setAlpha(0f);
        currentView.animate().setDuration(200);
        nextView.animate().setDuration(200);

        currentView.animate().alpha(0f).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                currentView.setVisibility(View.GONE);

                nextView.animate().alpha(1f).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        nextView.setVisibility(View.VISIBLE);
                    }
                });
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_signin:
                fadeViewToggle(mViewButtons, mSigninView);
                break;
            case R.id.btn_signup:
                fadeViewToggle(mViewButtons, mSignupView);
                break;
            case R.id.image_back_button_signin:
                fadeViewToggle(mSigninView, mViewButtons);
                break;
            case R.id.image_back_button_signup:
                fadeViewToggle(mSignupView, mViewButtons);
                break;
        }
    }
}
