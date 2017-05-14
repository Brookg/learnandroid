package cn.rabbitb.brook.a19_adapter_base_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 要显示的数据
        String[] datas = {"A", "B", "C", "D", "E"};

        // 创建 ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_expandable_list_item_1, datas);

        // 获取 ListView 对象
        ListView listView =(ListView) findViewById(R.id.listView);

        // 通过 setAdapter 方法为 ListView 设置 Adapter 适配器
        listView.setAdapter(adapter);

    }
}
