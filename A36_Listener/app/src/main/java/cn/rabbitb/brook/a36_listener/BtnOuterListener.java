package cn.rabbitb.brook.a36_listener;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

// 外部类
public class BtnOuterListener implements View.OnClickListener {
    private String text;
    private Context context;

    public BtnOuterListener(String text, Context context) {
        this.text = text;
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}
