package cn.rabbitb.brook.a17_dateandtime_1;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Chronometer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = (Chronometer) findViewById(R.id.timer);
        Button btnStart = (Button) findViewById(R.id.timerStart);
        Button btnStop = (Button) findViewById(R.id.timerStop);
        Button btnReset = (Button) findViewById(R.id.timerReset);
        Button btnFormat = (Button) findViewById(R.id.timerFormat);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.start();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.stop();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.setBase(SystemClock.elapsedRealtime());
            }
        });

        btnFormat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.setFormat("Timer: %s");
            }
        });

        timer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer timer) {
                String time = timer.getText().toString();
                if(time.equals("00:10")){
                    Toast.makeText(MainActivity.this, "10s 时间到", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
