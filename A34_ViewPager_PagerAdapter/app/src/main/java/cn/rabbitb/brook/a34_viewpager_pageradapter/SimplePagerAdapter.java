package cn.rabbitb.brook.a34_viewpager_pageradapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class SimplePagerAdapter extends PagerAdapter {
    private ArrayList<View> views;

    public SimplePagerAdapter(ArrayList<View> views) {
        this.views = views;
    }

    @Override
    public int getCount() {
        return views == null ? 0 : views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // 将给定位置的View添加到ViewGroup容器中，创建并显示出来
        container.addView(views.get(position));
        // 返回一个代表新增页面本身的key，通常返回页面本身就可以
        return views.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }
}
