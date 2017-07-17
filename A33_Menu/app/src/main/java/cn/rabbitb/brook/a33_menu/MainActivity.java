package cn.rabbitb.brook.a33_menu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textOptionMenu;
    private TextView textContextMenu;
    private TextView textSubMenu;
    private Button btnPopupMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        textOptionMenu = (TextView) findViewById(R.id.text_option_menu);
        textContextMenu = (TextView) findViewById(R.id.text_context_menu);
        textSubMenu = (TextView) findViewById(R.id.text_sub_menu);
        btnPopupMenu = (Button) findViewById(R.id.btn_popup_menu);

        // 注册上下文菜单
        registerForContextMenu(textContextMenu);
        registerForContextMenu(textSubMenu);

        // PopupMenu显示
        btnPopupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, btnPopupMenu);
                popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.popup_menu_red :
                                btnPopupMenu.setTextColor(Color.RED);
                                break;
                            case R.id.popup_menu_yellow :
                                btnPopupMenu.setTextColor(Color.YELLOW);
                                break;
                            case R.id.popup_menu_green :
                                btnPopupMenu.setTextColor(Color.GREEN);
                                break;
                            case R.id.popup_menu_blue :
                                btnPopupMenu.setTextColor(Color.BLUE);
                                break;
                            default:
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_red :
                textOptionMenu.setTextColor(Color.RED);
                break;
            case R.id.action_yellow :
                textOptionMenu.setTextColor(Color.YELLOW);
                break;
            case R.id.action_green :
                textOptionMenu.setTextColor(Color.GREEN);
                break;
            case R.id.action_blue :
                textOptionMenu.setTextColor(Color.BLUE);
                break;
            default:
        }

        return super.onOptionsItemSelected(item);
    }

    // 重写上下文菜单的创建方法，会在每一次长按View时被调用
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = new MenuInflater(this);
        switch (v.getId()) {
            case R.id.text_context_menu :
                inflater.inflate(R.menu.menu_context, menu);
                break;
            case R.id.text_sub_menu :
                inflater.inflate(R.menu.menu_sub, menu);
                break;
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    // 重写上下文菜单被点击后触发的方法
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.context_menu_red :
                textContextMenu.setTextColor(Color.RED);
                break;
            case R.id.context_menu_yellow :
                textContextMenu.setTextColor(Color.YELLOW);
                break;
            case R.id.context_menu_green :
                textContextMenu.setTextColor(Color.GREEN);
                break;
            case R.id.context_menu_blue :
                textContextMenu.setTextColor(Color.BLUE);
                break;
            case R.id.sub_menu_red :
                textSubMenu.setTextColor(Color.RED);
                break;
            case R.id.sub_menu_yellow :
                textSubMenu.setTextColor(Color.YELLOW);
                break;
            case R.id.sub_menu_green :
                textSubMenu.setTextColor(Color.GREEN);
                break;
            case R.id.sub_menu_blue :
                textSubMenu.setTextColor(Color.BLUE);
                break;
            default:
        }
        return true;
    }
}
