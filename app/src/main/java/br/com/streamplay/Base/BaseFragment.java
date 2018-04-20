package br.com.streamplay.Base;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

import br.com.streamplay.R;

public abstract class BaseFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(layoutId(), container, false);

        initialize();
        initView(view);
        initializeCompleted();

        return view;
    }

    public abstract void initialize();
    public abstract void initView(View view);
    public abstract int layoutId();
    public abstract void initializeCompleted();

}
