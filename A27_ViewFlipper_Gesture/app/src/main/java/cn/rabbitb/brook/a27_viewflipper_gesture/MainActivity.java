package cn.rabbitb.brook.a27_viewflipper_gesture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 动态导入子View
        ViewFlipper flipper = (ViewFlipper) findViewById(R.id.view_flipper);
        int[] resId = {R.id.flipper_1, R.id.flipper_2};
        for(int i = 0; i < resId.length; i++) {
            flipper.addView(findViewById(resId[i]));
        }

        // 实例化SimpleOnGestureListener和GestureDetector对象
        
    }
}
