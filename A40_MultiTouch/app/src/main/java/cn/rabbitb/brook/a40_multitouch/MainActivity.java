package cn.rabbitb.brook.a40_multitouch;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.image);
        image.setOnTouchListener(new View.OnTouchListener() {
            private PointF startPoint = new PointF();
            private static final int NONE = 0;
            private static final int DRAG = 1;
            private static final int ZOOM = 2;
            private int status = NONE;
            private Matrix savedMatrix = new Matrix();
            private Matrix matrix = new Matrix();
            private PointF midPoint = new PointF();
            private float oriDist = 1f;

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ImageView img = (ImageView) view;

                switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        // 手指按下，把当前矩阵保存下来
                        matrix.set(img.getImageMatrix());
                        savedMatrix.set(matrix);
                        // 记录拖动起始点
                        startPoint.set(motionEvent.getX(), motionEvent.getY());
                        status = DRAG;
                        break;
                    case MotionEvent.ACTION_POINTER_DOWN:
                        // 获取此刻两手指间距离作为单位1
                        oriDist = distance(motionEvent);
                        if (oriDist > 10) {
                            // 两手指按下，记录当前时刻矩阵
                            matrix.set(img.getImageMatrix());
                            savedMatrix.set(matrix);
                            // 记录两指的中点
                            midPoint.set(middle(motionEvent));
                            status = ZOOM;
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        status = NONE;
                        break;
                    case MotionEvent.ACTION_POINTER_UP:
                        status = DRAG;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (status == DRAG) {
                            // 单手拖动
                            matrix.set(savedMatrix);    // 以按下的时刻图片矩阵为起点
                            matrix.postTranslate(motionEvent.getX()-startPoint.x, motionEvent.getY()-startPoint.y);    // 位置变换
                            img.setImageMatrix(matrix);    // 应用变换
                        } else if (status == ZOOM) {
                            // 双手缩放
                            float dist = distance(motionEvent);
                            if (dist > 10) {
                                float scale = dist / oriDist;
                                matrix.set(savedMatrix);    // 以两指按下的时刻的图片为基础
                                matrix.postScale(scale, scale, midPoint.x, midPoint.y);    // 放缩变换
                                img.setImageMatrix(matrix);    // 应用变换
                            }
                        }
                        break;
                }

                return true;
            }
            // 计算两个触摸点之间的距离
            private float distance(MotionEvent event) {
                float x = event.getX(0) - event.getX(1);
                float y = event.getY(0) - event.getY(1);
                return (float) Math.sqrt(x * x + y * y);
            }

            // 计算两个触摸点的中点
            private PointF middle(MotionEvent event) {
                float x = event.getX(0) + event.getX(1);
                float y = event.getY(0) + event.getY(1);
                return new PointF(x / 2, y / 2);
            }
        });
    }
}
