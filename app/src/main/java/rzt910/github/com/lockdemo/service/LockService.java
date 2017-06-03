package rzt910.github.com.lockdemo.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.IntDef;

import rzt910.github.com.lockdemo.MyLockScreenActivity;
import rzt910.github.com.lockdemo.utils.LogUtil;

/**
 * Created by rzt09 on 2017/6/3.
 */

public class LockService extends Service {
    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        IntentFilter mScreenOnFilter = new IntentFilter();
        mScreenOnFilter.addAction(Intent.ACTION_SCREEN_OFF);
        mScreenOnFilter.addAction(Intent.ACTION_SCREEN_ON);
        LockService.this.registerReceiver(mScreenActionReceiver, mScreenOnFilter);

    }

    public void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(mScreenActionReceiver);
        // 在此重新启动,使服务常驻内存
        startService(new Intent(this, LockService.class));
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtil.debug("监听服务已启动");
        return super.onStartCommand(intent, flags, startId);

    }

    private BroadcastReceiver mScreenActionReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(Intent.ACTION_SCREEN_ON)) {
                Intent LockIntent = new Intent(LockService.this,MyLockScreenActivity.class);
                LockIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(LockIntent);
            } else if (action.equals(Intent.ACTION_SCREEN_OFF)) {
            }
        }
    };
}
