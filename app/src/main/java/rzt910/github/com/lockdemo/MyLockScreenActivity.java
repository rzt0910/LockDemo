package rzt910.github.com.lockdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;

import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;



public class MyLockScreenActivity extends AppCompatActivity {
    @BindView(R.id.iv_background)
    SimpleDraweeView background;
    private String urlAddress="http://o9f57g3sh.bkt.clouddn.com/589184.jpg";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_lock_screen);
        ButterKnife.bind(this);
        //将Activity显示在锁屏之上
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);

        GenericDraweeHierarchyBuilder builder =
                new GenericDraweeHierarchyBuilder(getResources());
        GenericDraweeHierarchy hierarchy = builder
                .setProgressBarImage(new ProgressBarDrawable())
                .setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE)
                .build();
        background.setHierarchy(hierarchy);
        background.setImageURI(urlAddress);

    }
}
