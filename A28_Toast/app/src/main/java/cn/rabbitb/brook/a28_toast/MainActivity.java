package cn.rabbitb.brook.a28_toast;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 简单的Toast
        Button simple = (Button) findViewById(R.id.simple);
        simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 设置文字和显示的时间
                Toast toast = Toast.makeText(MainActivity.this, "简单的Toast", Toast.LENGTH_SHORT);
                // 设置显示的位置
                toast.setGravity(Gravity.CENTER, 0, 0);
                // 设置字体的颜色
                TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                v.setTextColor(Color.GREEN);
                // 显示Toast
                toast.show();
            }
        });

        // 通过构造方法来定制Toast
        Button constructor = (Button) findViewById(R.id.constructor);
        constructor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
