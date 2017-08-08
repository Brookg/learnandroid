package cn.rabbitb.brook.a37_callback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        Log.i("自定义按钮", "Activity 重写的 onTouchEvent 函数被调用");
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button my_btn = (Button) findViewById(R.id.my_btn);
        my_btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.i("自定义按钮", "组件的 setOnTouchListener 中的方法被调用");
                return false;
            }
        });


    }
}
