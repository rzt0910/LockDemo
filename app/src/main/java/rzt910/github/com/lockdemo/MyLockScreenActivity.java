package rzt910.github.com.lockdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;



public class MyLockScreenActivity extends AppCompatActivity {
    @BindView(R.id.iv_background)
    SimpleDraweeView background;
    private String urlAddress="http://o9f57g3sh.bkt.clouddn.com/16-8-31/3221513.jpg";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_lock_screen);
        ButterKnife.bind(this);
        //将Activity显示在锁屏之上
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        background.setImageURI(urlAddress);


    }
}
