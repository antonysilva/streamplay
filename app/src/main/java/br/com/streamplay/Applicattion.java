package br.com.streamplay;

import android.app.Application;
import android.content.Context;

import br.com.streamplay.database.StreamPlayHelper;

/**
 * Created by Antony on 17/12/2017.
 */

public class Applicattion extends Application {
    public static StreamPlayHelper applicationHelper;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationHelper = new StreamPlayHelper(this);
    }
}
