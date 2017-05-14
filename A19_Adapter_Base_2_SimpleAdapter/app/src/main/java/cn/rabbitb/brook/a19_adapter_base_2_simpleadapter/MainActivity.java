package cn.rabbitb.brook.a19_adapter_base_2_simpleadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 准备要显示的每一项
        String[] titles = {"A", "B", "C"};
        String[] texts = {"Alice", "Bob", "Clark"};
        int[] imgIds = {R.drawable.alice, R.drawable.bob, R.drawable.clark};

        // 将要显示的数据封装起来
        List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
        for(int i = 0; i < titles.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("title", titles[i]);
            item.put("text", texts[i]);
            item.put("img", imgIds[i]);

            items.add(item);
        }

        // 创建一个 SimpleAdapter
        SimpleAdapter adapter = new SimpleAdapter(this, items, R.layout.list_item,
                new String[]{"title", "text", "img"},
                new int[]{R.id.title, R.id.text, R.id.img});

        // 获取 ListView 并应用 Adapter
        ListView listView = (ListView) findViewById(R.id.items);
        listView.setAdapter(adapter);

    }
}
