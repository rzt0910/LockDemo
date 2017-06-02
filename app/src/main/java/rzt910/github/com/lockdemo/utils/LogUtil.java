package rzt910.github.com.lockdemo.utils;


import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Created by rzt09 on 2017/6/3.
 */

public class LogUtil {
    private static boolean DEBUG =true;

    public static void debug(String str){
        Logger.d(str);
    }
    public static void error(String str){
        Logger.e(str);
    }
    public static void error(String str,Throwable throwable){
        Logger.e(throwable,str);
    }

    public static void init() {
        Logger.addLogAdapter(new AndroidLogAdapter(){
            @Override
            public boolean isLoggable(int priority, String tag) {
                return DEBUG;
            }
        });
    }
}
