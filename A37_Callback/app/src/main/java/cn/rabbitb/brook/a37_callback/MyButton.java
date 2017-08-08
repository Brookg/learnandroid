package cn.rabbitb.brook.a37_callback;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class MyButton extends android.support.v7.widget.AppCompatButton {
   private static String TAG = "自定义按钮";

    /* ----- 这些都是自动生成的构造函数 ----- */

    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /* ----- 开始重写回调函数 ----- */

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        super.onKeyDown(keyCode, event);
        Log.i(TAG, "onKeyDown 函数被调用");
        return true;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        super.onKeyUp(keyCode, event);
        Log.i(TAG, "onKeyUp 函数被调用");
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        Log.i(TAG, "组件定义中的 onTouchEvent 函数被调用");
        return false;
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        super.onKeyLongPress(keyCode, event);
        Log.i(TAG, "onKeyLongPress 函数被调用");
        return true;
    }
}
