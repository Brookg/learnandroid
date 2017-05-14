package cn.rabbitb.brook.a20_listview_simple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        list_animals.setAdapter(adapter);
    }
}
