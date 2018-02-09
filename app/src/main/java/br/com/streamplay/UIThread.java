package br.com.streamplay;

import android.os.Handler;
import android.os.Looper;

import br.com.streamplaydomain.base.MainThread;

/**
 * Created by Antony Silva on 09/02/2018.
 */

public class UIThread implements MainThread {

    private static MainThread sMainThread;

    private Handler mHandler;

    private UIThread() {
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void post(Runnable runnable) {
        mHandler.post(runnable);
    }

    public static MainThread getInstance() {
        if (sMainThread == null) {
            sMainThread = new UIThread();
        }

        return sMainThread;
    }

}
