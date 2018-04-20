package br.com.streamplay.login.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.yqritc.scalablevideoview.ScalableVideoView;

import br.com.streamplay.Base.BaseFragment;
import br.com.streamplay.R;
import br.com.streamplay.home.HomeActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends BaseFragment implements View.OnClickListener {

    private static LoginFragment instance;
    @BindView(R.id.videoview_splashscreem)
    public ScalableVideoView mVideoviewLogin;
    @BindView(R.id.btn_signin)
    public Button mSigninButton;
    @BindView(R.id.btn_signup)
    public Button mSignupButton;
    @BindView(R.id.image_back_button_signin)
    public ImageView mImageViewSiginBack;
    @BindView(R.id.image_back_button_signup)
    public ImageView mImageViewSigoutBack;
    @BindView(R.id.view_signin)
    public View mSigninView;
    @BindView(R.id.view_signup)
    public View mSignupView;
    @BindView(R.id.view_buttons)
    public View mViewButtons;

    public static LoginFragment getInstance() {
        if(instance == null)
            instance = new LoginFragment();
        return instance;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void initView(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public int layoutId() {
        return R.layout.fragment_login;
    }

    @Override
    public void initializeCompleted() {

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

    @OnClick(R.id.btn_login_button)
    public void signin(){
        startActivity(new Intent(getActivity(), HomeActivity.class));
    }
}
