package cn.rabbitb.brook.a21_baseadapter_optimize;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;

import cn.rabbitb.brook.a21_baseadapter_optimize.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 动态加载顶部 View 和 底部 View
        final LayoutInflater inflater = LayoutInflater.from(this);
        View headerView = inflater.inflate(R.layout.list_header, null, false);
        View footerView = inflater.inflate(R.layout.list_footer, null, false);

        // 要展示的数据
        LinkedList<Animal> animals = new LinkedList<>();
        animals.add(new Animal("牛", "我是一头牛", R.drawable.cow));
        animals.add(new Animal("蛇", "我是一条蛇", R.drawable.snake));
        animals.add(new Animal("狗", "我是一只狗", R.drawable.dog));
        animals.add(new Animal("猫", "我是一只猫", R.drawable.cat));

        // 初始化 Adapter
        AnimalAdapter adapter = new AnimalAdapter(animals, MainActivity.this);

        // 获取 ListView 视图并设置 Adapter
        ListView list_animals = (ListView) findViewById(R.id.list_animals);

        // 添加表头和表尾需要写在 setAdapter 方法调用之前
        list_animals.addHeaderView(headerView);
        list_animals.addFooterView(footerView);

        list_animals.setAdapter(adapter);

        // ListView 对点击事件的监听
        list_animals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "你点击了第 " + i + "项", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
