package br.com.streamplay.presenters;

import java.util.concurrent.TimeUnit;

import br.com.streamplaydomain.base.Executor;
import br.com.streamplaydomain.base.MainThread;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Antony on 09/12/2017.
 */

public class ApplicationPresenter {

    protected Executor mExecutor;
    protected MainThread mMainThread;

    public ApplicationPresenter(Executor executor, MainThread mainThread) {
        mExecutor = executor;
        mMainThread = mainThread;
    }

}
