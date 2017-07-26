package cn.rabbitb.brook.a35_drawerlayout_1;

import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Menu> menus;
    private DrawerLayout drawerLayout;
    private ListView menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        // 准备资源
        menus = new ArrayList<>();
        menus.add(new Menu(R.drawable.bell, getString(R.string.menu_realtime)));
        menus.add(new Menu(R.drawable.bubble, getString(R.string.menu_tip)));
        menus.add(new Menu(R.drawable.map, getString(R.string.menu_route)));
        menus.add(new Menu(R.drawable.config, getString(R.string.menu_config)));
        menuList = (ListView) findViewById(R.id.listView);
        // 实例化并应用Adapter
        MenuAdapter adapter = new MenuAdapter(menus, this);
        menuList.setAdapter(adapter);

        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ContentFragment fragment = new ContentFragment();
                Bundle args = new Bundle();
                args.putString("text", menus.get(i).getTitle());
                fragment.setArguments(args);
                FragmentManager fm = getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.main_content, fragment).commit();
                drawerLayout.closeDrawer(menuList);
            }
        });
    }
}
