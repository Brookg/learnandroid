package cn.rabbitb.brook.a34_viewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

public class PagerAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_adapter);

        // 设置资源
        ArrayList<View> views = new ArrayList<>();
        LayoutInflater inflater = getLayoutInflater();
        views.add(inflater.inflate(R.layout.page1_1, null, false));
        views.add(inflater.inflate(R.layout.page1_2, null, false));
        views.add(inflater.inflate(R.layout.page1_3, null, false));
        views.add(inflater.inflate(R.layout.page1_4, null, false));

        // 应用Adapter
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager_1);
        SimplePagerAdapter adapter = new SimplePagerAdapter(views);
        viewPager.setAdapter(adapter);
    }
}
