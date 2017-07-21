package cn.rabbitb.brook.a34_viewpager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class PagerTitleAdapter extends PagerAdapter {
    private ArrayList<View> views;
    private ArrayList<String> titles;

    public PagerTitleAdapter(ArrayList<View> views, ArrayList<String> titles) {
        this.views = views;
        this.titles = titles;
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
        // 将指定位置的View添加到ViewGroup中
        container.addView(views.get(position));
        // 返回该View的Key，通常是该View本身
        return views.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
