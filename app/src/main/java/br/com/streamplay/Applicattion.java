package br.com.streamplay;

import android.app.Application;

import br.com.streamplay.database.StreamPlayHelper;

/**
 * Created by Antony on 17/12/2017.
 */

public class Applicattion extends Application {

    public static StreamPlayHelper mHelper = new StreamPlayHelper(this);
}
