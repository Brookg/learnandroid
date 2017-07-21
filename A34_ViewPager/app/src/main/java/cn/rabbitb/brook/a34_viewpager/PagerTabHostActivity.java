package cn.rabbitb.brook.a34_viewpager;

import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PagerTabHostActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ImageView img_cursor;
    private int screenWidth;
    private int offset;
    private int currentIndex;
    private int currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_tab_host);

        // 准备资源
        ArrayList<View> views = new ArrayList<>();
        LayoutInflater inflater = getLayoutInflater();
        views.add(inflater.inflate(R.layout.page1_1, null, false));
        views.add(inflater.inflate(R.layout.page1_2, null, false));
        views.add(inflater.inflate(R.layout.page1_3, null, false));
        // 创建Adapter并应用
        SimplePagerAdapter adapter = new SimplePagerAdapter(views);
        viewPager = (ViewPager) findViewById(R.id.viewpager_4);
        viewPager.setAdapter(adapter);

        // 实现点击标题切换页面
        TextView tv1 = (TextView) findViewById(R.id.tv4_1);
        TextView tv2 = (TextView) findViewById(R.id.tv4_2);
        TextView tv3 = (TextView) findViewById(R.id.tv4_3);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0);
            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
            }
        });

        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(2);
            }
        });

        // 下划线图片相关参数初始化

        // 获取图片宽度
        int bmpWidth = BitmapFactory.decodeResource(getResources(), R.mipmap.line).getWidth();
        // 获取屏幕分辨率
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        screenWidth = dm.widthPixels;
        // 计算最左侧TextView和屏幕左边的距离
        offset = (screenWidth / 3 - bmpWidth) / 2;

        // 设置下划线图片初始位置
        Matrix matrix = new Matrix();
        matrix.postTranslate(offset, 0);
        img_cursor = (ImageView) findViewById(R.id.img_cursor);
        img_cursor.setImageMatrix(matrix);

        // 当前页面
        currentIndex = 0;
        currentPos = offset;

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Animation animation = null;
                int newPos = screenWidth / 3 * position;

                animation = new TranslateAnimation(currentPos, newPos, 0, 0);
                animation.setFillAfter(true);    // 图片停在动画停止位置
                animation.setDuration(300);    // 动画时间
                img_cursor.startAnimation(animation);    // 开始动画

                currentIndex = position;
                currentPos = newPos;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
