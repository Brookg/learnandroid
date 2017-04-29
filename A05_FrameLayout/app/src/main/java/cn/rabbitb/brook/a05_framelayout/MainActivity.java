package cn.rabbitb.brook.a05_framelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout frame = (FrameLayout) findViewById(R.id.mylayout);
        final MeiziView meizi = new MeiziView(MainActivity.this);

        // 为我们的萌妹子添加触摸事件监听器
        meizi.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // 设置妹子要显示的位置
                meizi.setX(event.getX() - 150);
                meizi.setY(event.getY() - 150);
                // 调用重绘方法
                meizi.invalidate();
                return true;
            }
        });

        // 将妹子 View 添加入 FrameLayout 中
        frame.addView(meizi);
    }
}
