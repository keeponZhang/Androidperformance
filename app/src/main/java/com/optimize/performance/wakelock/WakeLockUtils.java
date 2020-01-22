package com.optimize.performance.wakelock;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;

public class WakeLockUtils {

    private static PowerManager.WakeLock sWakeLock;

    public static void acquire(Context context){
        if(sWakeLock == null){
            sWakeLock = createWakeLock(context);
        }
        if(sWakeLock != null && !sWakeLock.isHeld()){
            // 如果我们调用的是acquire(long timeout)那么就无需我们自己手动调用release()来释放锁，系统会帮助我们在timeout时间后释放。
            // 如果我们调用的是acquire()那么就需要我们自己手动调用release()来释放锁。
            sWakeLock.acquire();
            sWakeLock.acquire(1000);
        }
    }

    public static void release(){
        // 一些逻辑
        try{

        }catch (Exception e){

        }finally {
            // 为了演示正确的使用方式
            if(sWakeLock != null && sWakeLock.isHeld()){
                sWakeLock.release();
                sWakeLock = null;
            }
        }
    }

    @SuppressLint("InvalidWakeLockTag")
    private static PowerManager.WakeLock createWakeLock(Context context){
        PowerManager pm = (PowerManager) context.getApplicationContext().getSystemService(Context.POWER_SERVICE);
        if(pm != null){
            return pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,"");
        }
        return null;
    }

}
