package cn.rabbitb.brook.a34_viewpager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_pager_adapter = (Button) findViewById(R.id.btn_pager_adapter);
        btn_pager_adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PagerAdapterActivity.class));
            }
        });

        Button btn_pager_strip_title = (Button) findViewById(R.id.btn_pager_title_strip);
        btn_pager_strip_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PagerTitleStripActivity.class));
            }
        });

        Button btn_pager_tab_title = (Button) findViewById(R.id.btn_pager_tab_strip);
        btn_pager_tab_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PagerTabStripActivity.class));
            }
        });

        Button btn_pager_tab_host = (Button) findViewById(R.id.btn_pager_tab_host);
        btn_pager_tab_host.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PagerTabHostActivity.class));
            }
        });
    }
}
