package cn.rabbitb.brook.a29_notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private NotificationManager notificationManager;
    private static int NOTIFY_ID = 1;
    private Notification cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bShowNormal = (Button) findViewById(R.id.show_normal);
        Button bCloseNormal = (Button) findViewById(R.id.close_normal);

        // 创建 NotificationManager
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        bShowNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 准备一个PendingIntent，实现点击后跳转到另外的Activity
                Intent it = new Intent(MainActivity.this, CatActivity.class);
                PendingIntent pit = PendingIntent.getActivity(MainActivity.this, 0, it, 0);

                // 创建大图标的Bitmap
                Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.cat);

                // 创建Notification.Builder，设置相关属性
                Notification.Builder builder = new Notification.Builder(MainActivity.this);

                builder.setContentTitle(getString(R.string.cat_title))
                        .setContentText(getString(R.string.hello_cat))
                        .setTicker(getString(R.string.cat_ticker))
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.drawable.little_cat)
                        .setLargeIcon(largeIcon)
                        // .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE)
                        .setAutoCancel(true)
                        .setContentIntent(pit);

                // 创建并触发Notification
                cat = builder.getNotification();

                /* 需要 API 16 及以上版本 *
                cat = builder.build();
                /**/

                notificationManager.notify(NOTIFY_ID, cat);

            }
        });

        bCloseNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationManager.cancel(NOTIFY_ID);
            }
        });
    }
}
