package rzt910.github.com.lockdemo;

import android.app.Application;
import android.app.Service;
import android.content.Intent;

import com.facebook.drawee.backends.pipeline.Fresco;

import rzt910.github.com.lockdemo.service.LockService;
import rzt910.github.com.lockdemo.utils.LogUtil;

/**
 * Created by rzt09 on 2017/6/3.
 */

public class Myapplication extends Application {
   private static Myapplication application =null;
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.init();
        Fresco.initialize(this);
        Intent intent = new Intent(Myapplication.this,LockService.class);
        startService(intent);

    }
    public static Myapplication getInstance(){
        if (application==null){
            application =new Myapplication();
        }
        return application;
    }
}
