package cn.rabbitb.brook.a26_expandablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 数据准备
        LinkedList<Group> groups = new LinkedList<>();
        LinkedList<LinkedList<Item>> items = new LinkedList<>();
        LinkedList<Item> item;

        groups.add(new Group("哺乳动物"));
        item = new LinkedList<>();
        item.add(new Item(R.drawable.monkey, "猴子"));
        item.add(new Item(R.drawable.panda, "熊猫"));
        item.add(new Item(R.drawable.rabbit, "兔子"));
        items.add(item);

        groups.add(new Group("节肢动物"));
        item = null;
        item = new LinkedList<>();
        item.add(new Item(R.drawable.spider, "蜘蛛"));
        items.add(item);

        groups.add(new Group("爬行动物"));
        item = null;
        item = new LinkedList<>();
        item.add(new Item(R.drawable.snake, "蛇"));
        items.add(item);

        // 获取视图
        ExpandableListView expandableList = (ExpandableListView) findViewById(R.id.expandableList);

        // 应用适配器
        MyExpandableListAdapter myExpandableListAdapter = new MyExpandableListAdapter(groups, items, MainActivity.this);
        expandableList.setAdapter(myExpandableListAdapter);
    }
}
