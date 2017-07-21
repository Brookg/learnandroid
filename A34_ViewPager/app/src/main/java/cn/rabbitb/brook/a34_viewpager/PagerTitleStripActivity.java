package cn.rabbitb.brook.a34_viewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

public class PagerTitleStripActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_title_strip);

        // 准备数据
        ArrayList<View> views = new ArrayList<>();
        LayoutInflater inflater = getLayoutInflater();
        views.add(inflater.inflate(R.layout.page1_1, null, false));
        views.add(inflater.inflate(R.layout.page1_2, null, false));
        views.add(inflater.inflate(R.layout.page1_3, null, false));
        views.add(inflater.inflate(R.layout.page1_4, null, false));

        ArrayList<String> titles = new ArrayList<>();
        titles.add(getString(R.string.page_one));
        titles.add(getString(R.string.page_two));
        titles.add(getString(R.string.page_three));
        titles.add(getString(R.string.page_four));

        // 初始化PagerAdapter
        PagerTitleAdapter adapter = new PagerTitleAdapter(views, titles);

        // 获取ViewPager
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager_2);
        // 设置PagerAdapter
        viewPager.setAdapter(adapter);
    }
}
