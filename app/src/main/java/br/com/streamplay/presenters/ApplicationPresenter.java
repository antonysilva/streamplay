package br.com.streamplay.presenters;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Antony on 09/12/2017.
 */

public class ApplicationPresenter {

    private static String URL_BASE = "https://private-96e6c4-streamplay1.apiary-mock.com";

    public Retrofit getConection(){
        Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(URL_BASE)
                            .client(client)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

        return retrofit;
    }

    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BASIC);
    OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .readTimeout(60 , TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build();

}
