package cn.rabbitb.brook.a09_button;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.SystemClock;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;


public class ClickWaveButton extends android.support.v7.widget.AppCompatButton {
    private static final int FLUSH_PERIOD = 15;
    private int speed;
    private static int CLICK_TIMEOUT;
    private Context context;
    private Paint frontPaint, backPaint;    // 两支画笔
    private long downtime;    // 按下那一瞬间的时间，类似于时间戳
    private int eventX, eventY;    // 按下的位置
    private boolean isPressed;    // 记录按钮是否被按下
    private int viewWidth, viewHeight;    // 控件的宽、高、左上角点坐标
    private int shaderRadio, maxRadio;    // 扩散的半径，最大半径

    public ClickWaveButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.initPaint();
        CLICK_TIMEOUT = ViewConfiguration.getLongPressTimeout();
        this.downtime = 0;
        this.speed = 1;
        this.isPressed = false;
        this.shaderRadio = 0;
    }

    // 初始化画笔
    private void initPaint() {
        this.frontPaint = new Paint();
        this.backPaint = new Paint();
        this.frontPaint.setColor(ContextCompat.getColor(this.context, R.color.wave_front));
        this.backPaint.setColor(ContextCompat.getColor(this.context, R.color.wave_back));
    }

    // 重写触摸事件处理逻辑
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN :
                // SystemClock.elapsedRealtime() 系统从启动到现在的时间
                if(this.downtime == 0)  this.downtime = SystemClock.elapsedRealtime();
                this.eventX = (int) event.getX();
                this.eventY = (int) event.getY();
                this.countMaxRadio();
                this.isPressed = true;
                this.postInvalidateDelayed(FLUSH_PERIOD);
                break;
            case MotionEvent.ACTION_CANCEL :
            case MotionEvent.ACTION_UP :
                if(SystemClock.elapsedRealtime() - this.downtime < CLICK_TIMEOUT) {
                    this.speed = 10;
                    this.postInvalidate();
                } else {
                    this.clearData();
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    // 计算最大半径
    private void countMaxRadio() {
        if(this.viewWidth > this.viewHeight) {
            if(this.eventX < this.viewWidth / 2) {
                this.maxRadio = this.viewWidth - this.eventX;
            } else {
                this.maxRadio = this.eventX;
            }
        } else {
            if(this.eventY < this.viewHeight / 2) {
                this.maxRadio = this.viewHeight - this.eventY;
            } else {
                this.maxRadio = this.eventY;
            }
        }
    }

    // 重写绘画方法
    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);

        // 如果按钮没有被按下则返回
        if(!this.isPressed)  return;

        // 绘制按下后的整个背景
        canvas.drawRect(0, 0, this.viewWidth, this.viewHeight, this.backPaint);
        canvas.save();
        // 绘制扩散圆形的背景
        canvas.clipRect(0, 0, this.viewWidth, this.viewHeight);
        canvas.drawCircle(this.eventX, this.eventY, this.shaderRadio, this.frontPaint);
        canvas.restore();

        // 直到半径等于最大半径
        if(this.shaderRadio < this.maxRadio) {
            this.postInvalidateDelayed(FLUSH_PERIOD, 0, 0,
                    this.viewWidth, this.viewHeight);
            this.shaderRadio += this.speed;
        } else {
            this.clearData();
        }
    }

    // 重置数据
    private void clearData() {
        this.downtime = 0;
        this.speed = 1;
        this.isPressed = false;
        this.shaderRadio = 0;
        this.postInvalidate();
    }

    // 改变大小时重新设置控件大小
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.viewWidth = w;
        this.viewHeight = h;
    }
}
