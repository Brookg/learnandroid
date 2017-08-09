package cn.rabbitb.brook.a38_handler_childthread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "EditTextNumber";
    private EditText etNum;
    private CalThread calThread;

    class CalThread extends Thread {
        private Handler handler;

        @Override
        public void run() {
            // prepare
            Looper.prepare();

            // 定义 Handler
            handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    if (msg.what == 0x123) {
                        Toast.makeText(MainActivity.this, msg.getData().getInt(TAG) + "", Toast.LENGTH_SHORT).show();
                    }
                }
            };

            // loop
            Looper.loop();
        }

        public Handler getHandler() {
            return handler;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum = (EditText) findViewById(R.id.etNum);
        // 启动子线程
        calThread = new CalThread();
        calThread.start();
    }

    // 为按钮的点击事件提供事件处理函数
    public void cal(View source)
    {
        Bundle bundle = new Bundle();
        bundle.putInt(TAG, Integer.parseInt(etNum.getText().toString()));
        Message msg = new Message();
        msg.what = 0x123;
        msg.setData(bundle);
        calThread.getHandler().sendMessage(msg);
    }
}
