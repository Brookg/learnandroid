package cn.rabbitb.brook.a16_scrollview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn2top = (Button) this.findViewById(R.id.btn2top);
        Button btn2bottom = (Button) this.findViewById(R.id.btn2bottom);
        this.scrollView = (ScrollView) this.findViewById(R.id.scrollView);
        TextView textView = (TextView) this.findViewById(R.id.textView);

        for(int i = 0; i < 100; i++) {
            textView.append("This is line " + (i+1) + " .");
            if(i < 99) textView.append("\n");
        }

        btn2top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrollView.fullScroll(ScrollView.FOCUS_UP);
            }
        });
        btn2bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
    }
}
