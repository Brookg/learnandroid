package cn.rabbitb.brook.a32_popupwindow;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button show_pop = (Button) findViewById(R.id.show_pop);
        show_pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.pop, null, false);
                Button btn_happy = (Button) view.findViewById(R.id.btn_happy);
                Button btn_sad = (Button) view.findViewById(R.id.btn_sad);

                // 构造一个PopupWindow，参数依次是加载的View、宽、高
                popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                // 设置加载动画
                popupWindow.setAnimationStyle(R.anim.pop);

                // 代码作用(教程)：点击非PopupWindow区域，PopupWindow会消失
                // 否则，无论按多少次后退键，PopupWindow都不会关闭
/*                popupWindow.setTouchable(true);
                popupWindow.setTouchInterceptor(new View.OnTouchListener() {    // interceptor--拦截器
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        return false;
                        // 若设置为true，则点击外部区域无法dismiss
                    }
                });
*/
                // 代码作用：点击非PopupWindow区域，PopupWindow会消失
                // 经过实践是可以实现效果的，上面的代码在有的教程里并没有出现，而且注释掉貌似并不影响
                popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
                popupWindow.setOutsideTouchable(true);

                // 设置PopupWindow显示的位置
                popupWindow.showAsDropDown(v);

                // 设置PopupWindow里的按钮事件
                btn_happy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "你今天的心情是高兴的", Toast.LENGTH_SHORT).show();
                        popupWindow.dismiss();
                    }
                });
                btn_sad.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "你今天的心情是悲伤的", Toast.LENGTH_SHORT).show();
                        popupWindow.dismiss();
                    }
                });
            }
        });
    }
}
