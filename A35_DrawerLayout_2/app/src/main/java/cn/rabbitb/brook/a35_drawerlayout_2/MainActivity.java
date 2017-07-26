package cn.rabbitb.brook.a35_drawerlayout_2;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        LeftFragment fg_left = (LeftFragment) getSupportFragmentManager().findFragmentById(R.id.fg_left);
        RightFragment fg_right = (RightFragment) getSupportFragmentManager().findFragmentById(R.id.fg_right);
        fg_left.setDrawerLayout(drawerLayout);
        fg_right.setDrawerLayout(drawerLayout);

        Button btn_right = (Button) findViewById(R.id.btn_right);
        btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.END);
            }
        });
    }
}
