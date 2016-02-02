package com.awesomeproject; /**
 * Created by david on 25.01.16.
 */

import android.app.Application;

import com.localytics.android.*;

public class MyApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        registerActivityLifecycleCallbacks(new LocalyticsActivityLifecycleCallbacks(this));
    }

}

