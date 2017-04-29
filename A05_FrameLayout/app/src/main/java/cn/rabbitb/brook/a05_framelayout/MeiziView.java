package cn.rabbitb.brook.a05_framelayout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;


public class MeiziView extends View {
    // 妹子显示位置 X 坐标
    private float bitmapX;
    // 妹子显示坐标 Y 坐标
    private float bitmapY;

    private Paint paint;
    private Bitmap bitmap;

    public MeiziView(Context context) {
        super(context);
        // 妹子显示初始位置
        this.bitmapX = 0;
        this.bitmapY = 200;
        // 创建，并实例化 Paint 对象
        this.paint = new Paint();
        // 根据图片生成位图图像
        this.bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.s_jump);
    }

    // 重写 View 的 OnDraw 方法
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 绘制图像
        canvas.drawBitmap(this.bitmap, this.bitmapX, this.bitmapY, this.paint);
        // 判断图片是否回收，没有的话要手动回收图片
        // brook : 和原来的代码不同，这里将 paint 和 bitmap 都不是重绘时分配的，所以这里图片资源也不回收
        // 若回收也应该是 View 无用的时候吧，可是还没有学到该怎样做
//        if(!this.bitmap.isRecycled()) {
//            this.bitmap.recycle();
//        }
    }

    public void setX(float bitmapX) {
        this.bitmapX = bitmapX;
    }

    public void setY(float bitmapY) {
        this.bitmapY = bitmapY;
    }
}
