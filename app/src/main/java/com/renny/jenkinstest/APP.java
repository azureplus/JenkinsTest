package com.renny.jenkinstest;

import android.support.multidex.MultiDexApplication;
import android.util.Log;

/**
 * @author Created by Renny on on 2018/3/20
 */

public class APP extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG", "onCreate--  " + android.os.Process.myPid());
    }
}
