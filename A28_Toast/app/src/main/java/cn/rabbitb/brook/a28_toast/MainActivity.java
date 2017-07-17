package cn.rabbitb.brook.a28_toast;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
                // 设置文字和显示时间
                Toast toast = Toast.makeText(MainActivity.this, "喵~", Toast.LENGTH_SHORT);
                // 设置显示的位置
                toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP, 0, 0);
                // 获取Layout
                LinearLayout layout = (LinearLayout) toast.getView();
                // 添加图片
                ImageView image = new ImageView(MainActivity.this);
                image.setImageResource(R.drawable.cat);
                layout.addView(image, 0);
                // 设置字体颜色和对齐方式
                TextView text = (TextView) toast.getView().findViewById(android.R.id.message);
                text.setTextColor(Color.YELLOW);
                layout.setGravity(Gravity.CENTER_HORIZONTAL);
                // 显示toast
                toast.show();
            }
        });

        // 完全自定义的Toast
        Button customized = (Button) findViewById(R.id.customized);
        customized.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 将Layout转换成View
                LayoutInflater inflater = MainActivity.this.getLayoutInflater();
                View v = inflater.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.toast_layout));
                // 从View中获取元素，并根据需要设置每个元素的属性
                ImageView icon = (ImageView) v.findViewById(R.id.icon);
                TextView msg = (TextView) v.findViewById(R.id.msg);
                msg.setText(getText(R.string.hello_cat));
                // 使用自定义View生成Toast
                Toast toast = new Toast(MainActivity.this);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(v);
                toast.show();
            }
        });
    }
}
