package cn.rabbitb.brook.a22_listview_dataupdate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;

import cn.rabbitb.brook.a22_listview_dataupdate.R;

public class MainActivity extends AppCompatActivity {

    private int animalCnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 要展示的数据
        LinkedList<Animal> animals = new LinkedList<>();
//        animals.add(new Animal("牛", "我是一头牛", R.drawable.cow));
//        animals.add(new Animal("蛇", "我是一条蛇", R.drawable.snake));
//        animals.add(new Animal("狗", "我是一只狗", R.drawable.dog));
//        animals.add(new Animal("猫", "我是一只猫", R.drawable.cat));

        // 初始化 Adapter
        final AnimalAdapter adapter = new AnimalAdapter(animals, MainActivity.this);

        // 获取 ListView 视图并设置 Adapter
        ListView list_animals = (ListView) findViewById(R.id.list_animals);
        list_animals.setAdapter(adapter);

        // ListView 对点击事件的监听
        list_animals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "你点击了第 " + i + "项", Toast.LENGTH_SHORT).show();
            }
        });

        // 对 增加一条记录 按钮的点击事件监听
        animalCnt = 0;
        Button btnAddOne = (Button) findViewById(R.id.addOne);
        btnAddOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animalCnt++;
                adapter.add(new Animal("狗", "我是第 " + animalCnt + " 只动物", R.drawable.dog));
            }
        });
    }
}
