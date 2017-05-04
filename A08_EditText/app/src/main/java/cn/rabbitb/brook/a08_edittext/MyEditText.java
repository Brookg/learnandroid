package cn.rabbitb.brook.a08_edittext;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.EditText;

/**
 * Created by mm on 2017/5/4.
 */

public class MyEditText extends android.support.v7.widget.AppCompatEditText {

    private final static String TAG = "MyEditText";
    private Drawable cancelpng;
    private Context mContext;

    public MyEditText(Context context) {
        super(context);
        this.init(context);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init(context);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        this.cancelpng = ResourcesCompat.getDrawable(getResources(), R.drawable.cancel, null);
        this.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }
            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
            }
            @Override
            public void afterTextChanged(Editable arg0) {
                if(MyEditText.this.length() < 1) {
                    MyEditText.this.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                } else {
                    MyEditText.this.setCompoundDrawablesWithIntrinsicBounds(null, null, MyEditText.this.cancelpng, null);
                }
            }
        });
    }

    public boolean onTouchEvent(MotionEvent event) {
        if(this.cancelpng != null && event.getAction() == MotionEvent.ACTION_UP) {
            int eventX = (int) event.getRawX();
            int eventY = (int) event.getRawY();
            Log.e(TAG, "EventX = " + eventX + ", EventY = " + eventY);
            Rect rect = new Rect();
            this.getGlobalVisibleRect(rect);
            rect.left = rect.right - 30;
            if(rect.contains(eventX, eventY)) {
                this.setText("");
            }
        }
        return super.onTouchEvent(event);
    }



}
