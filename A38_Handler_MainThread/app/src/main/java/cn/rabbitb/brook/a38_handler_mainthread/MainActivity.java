package cn.rabbitb.brook.a38_handler_mainthread;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private static int[] imgIds = new int[] {
        R.drawable.dance_1, R.drawable.dance_2, R.drawable.dance_3, R.drawable.dance_4,
        R.drawable.dance_5, R.drawable.dance_6, R.drawable.dance_7, R.drawable.dance_8
    };
    private int imgIndex = 0;
    private ImageView img;
    private Handler imgHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            imgIndex++;
            if (imgIndex > 7) {
                imgIndex = 0;
            }
            if (msg.what == 0x123) {
                img.setImageResource(imgIds[imgIndex]);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.img);

        // 使用定时器，每200ms让Handler发送一个空信息
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                imgHandler.sendEmptyMessage(0x123);
            }
        }, 0, 200);
    }
}
