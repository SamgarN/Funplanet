package com.example.samgar.funplanet.AppControler;

/**
 * Created by samgar on 12/12/16.
 */
import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class AppController extends Application {
    private RequestQueue mRequestQueue ;
    private static AppController mInstance ;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this ;
    }

    public static AppController getInstance(){
        return mInstance ;
    }

    public RequestQueue getRequestQueue(){
        if(mRequestQueue == null)
            mRequestQueue = Volley.newRequestQueue(getApplicationContext()) ;
        return  mRequestQueue ;
    }
}
