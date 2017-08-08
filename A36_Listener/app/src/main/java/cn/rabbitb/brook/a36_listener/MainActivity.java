package cn.rabbitb.brook.a36_listener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/* ----- Method 4 : 使用Activity实现View.OnClickListener ----- */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* ----- Method 1 : 使用匿名类 ----- */
        Button btn_anonymous = (Button) findViewById(R.id.btn_anonymous);
        btn_anonymous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "使用匿名类", Toast.LENGTH_SHORT).show();
            }
        });

        /* ----- Method 2 : 使用内部类 ----- */
        Button btn_inner = (Button) findViewById(R.id.btn_inner);
        btn_inner.setOnClickListener(new BtnInnerLister());

        /* ----- Method 3 : 使用外部类 ----- */
        Button btn_outer = (Button) findViewById(R.id.btn_outer);
        btn_outer.setOnClickListener(new BtnOuterListener("使用外部类", MainActivity.this));

        /* ----- Method 4 : 使用Activity实现View.OnClickListener ----- */
        Button btn_activity = (Button) findViewById(R.id.btn_activity);
        btn_activity.setOnClickListener(this);
    }

    @Override
    // 实现 onClick 方法
    public void onClick(View view) {
        if (view.getId() == R.id.btn_activity) {
            Toast.makeText(this, "使用Activity作为事件监听器", Toast.LENGTH_SHORT).show();
        }
    }

    // 内部类
    // 实现 View.OnClickListener , 重写 onClick 方法
    class BtnInnerLister implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "使用内部类", Toast.LENGTH_SHORT).show();
        }
    }

    /* ----- Method 5 : 自定义方法，并在XML中指定 ----- */
    public void btnXMLClick(View view) {
        Toast.makeText(this, "在XML中指定", Toast.LENGTH_SHORT).show();
    }
}
