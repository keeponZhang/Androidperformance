package com.optimize.performance.tasks;

import android.app.Application;
import android.os.SystemClock;

import com.optimize.performance.launchstarter.task.MainTask;
import com.taobao.weex.InitConfig;
import com.taobao.weex.WXSDKEngine;

/**
 * 主线程执行的task
 */
public class InitWeexTask extends MainTask {

    @Override
    public boolean runOnMainThread() {
        return false;
    }
    @Override
    public boolean needWait() {
        return true;
    }

    @Override
    public void run() {
        // SystemClock.sleep(2000);
        InitConfig config = new InitConfig.Builder().build();
        WXSDKEngine.initialize((Application) mContext, config);
    }
}
