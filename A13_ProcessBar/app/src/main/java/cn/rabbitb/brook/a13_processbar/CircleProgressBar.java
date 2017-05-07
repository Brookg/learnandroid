package cn.rabbitb.brook.a13_processbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


public class CircleProgressBar extends View {

    private static final float STROKE_WIDTH = 10;
    private static final float RADIUS = 50;
    private static final int FONT_SIZE = 18;
    private Paint backPaint;
    private Paint frontPaint;
    private Paint textPaint;
    private int viewWidth, viewHeight;    // 控件的宽、高
    private RectF rect;    // 画圆弧时需要用到的外矩形
    private int total = 100;
    private int progress = 10;
    private int targetProgress = 90;


    // 重写三个构造方法
    public CircleProgressBar(Context context) {
        super(context);
        this.init();
    }

    public CircleProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public CircleProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();
    }

    // 完成参数初始化
    private void init() {
        this.backPaint = new Paint();
        this.backPaint.setColor(Color.WHITE);
        this.backPaint.setAntiAlias(true);    // 抗边缘锯齿
        this.backPaint.setStyle(Paint.Style.STROKE);
        this.backPaint.setStrokeWidth(STROKE_WIDTH);

        this.frontPaint = new Paint();
        this.frontPaint.setColor(Color.GREEN);
        this.frontPaint.setAntiAlias(true);
        this.frontPaint.setStyle(Paint.Style.STROKE);
        this.frontPaint.setStrokeWidth(STROKE_WIDTH);

        this.textPaint = new Paint();
        this.textPaint.setColor(Color.GREEN);
        this.textPaint.setAntiAlias(true);
        this.textPaint.setTextSize(FONT_SIZE);
        this.textPaint.setTextAlign(Paint.Align.CENTER);
    }

    // 重写 onMeasure 方法，测量大小
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.viewWidth = this.getRealSize(widthMeasureSpec);
        this.viewHeight = this.getRealSize(heightMeasureSpec);
        this.setMeasuredDimension(this.viewWidth, this.viewHeight);

        Log.d("widthMeasureSpec", widthMeasureSpec + "");
        Log.d("viewWidth", this.viewWidth + "");
        Log.d("viewHeight", this.viewHeight + "");
    }

    // 重写 onDraw 方法，这是绘制 View 的核心方法
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.initRect();
        float angle = this.progress / (float) this.total * 360;
        canvas.drawCircle(this.viewWidth / 2, this.viewHeight, RADIUS, this.backPaint);
        canvas.drawArc(this.rect, -90, angle, false, frontPaint);
        canvas.drawText(this.progress + " %", (this.viewWidth + STROKE_WIDTH) / 2,
                (this.viewHeight + STROKE_WIDTH) / 2, this.textPaint);
        if(this.progress < this.targetProgress) {
            this.progress += 1;
            this.invalidate();
        }
    }

    // 计算实际大小
    private int getRealSize(int measureSpec) {
        int result = 1;
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);

        if(mode == MeasureSpec.AT_MOST || mode == MeasureSpec.UNSPECIFIED) {
            // 若没有指定，则自己计算
            result = (int) (RADIUS * 2 + STROKE_WIDTH);
        } else {
            // 若已经指定，则为指定的值
            result = size;
        }

        return result;
    }

    // 矩形初始化
    private void initRect() {
        if(this.rect == null) {
            this.rect = new RectF();
            int viewSize = (int) (RADIUS * 2);
            int left = (this.viewWidth - viewSize) / 2;
            int top = (this.viewHeight - viewSize) / 2;
            int right = left + viewSize;
            int bottom = top + viewSize;
            this.rect.set(left, top, right, bottom);
        }
    }
}
