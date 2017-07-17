package cn.rabbitb.brook.a31_somedialogs;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private int p;
    private final static int MAXVALUE = 100;
    private ProgressDialog pdDet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* 普通圆形进度条对话框 */
        Button btnProgCir = (Button) findViewById(R.id.btn_progress_circle);
        btnProgCir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog.show(MainActivity.this, "资源加载中", "资源加载中，请稍后...", false, true);
            }
        });

        /* 条形不显示进度对话框 */
        Button btnProgBarIndet = (Button) findViewById(R.id.btn_progress_bar_indet);
        btnProgBarIndet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 实例化进度条对话框
                ProgressDialog pd = new ProgressDialog(MainActivity.this);
                // 设置属性
                pd.setTitle("软件更新中");
                pd.setMessage("软件正在更新中，请稍后...");
                pd.setCancelable(true);
                // 设置风格——条形，无进度
                pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pd.setIndeterminate(true);
                // 显示
                pd.show();
            }
        });

        /* 条形显示进度对话框 */
        Button btnProgBarDet = (Button) findViewById(R.id.btn_progress_bar_det);
        btnProgBarDet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 实例化进度条对话框
                final ProgressDialog pdDet = new ProgressDialog(MainActivity.this);
                // 设置属性
                pdDet.setTitle("文件读取中");
                pdDet.setMessage("文件加载中，请稍后...");
                pdDet.setCancelable(true);
                // 设置风格
                pdDet.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pdDet.setIndeterminate(false);
                // 显示
                pdDet.show();

                // 初始化进度
                p = 0;
                // 新建线程，以更新进度
                new Thread() {
                    public void run() {
                        while (p < MAXVALUE) {
                            try {
                                Thread.sleep(500);
                                p += 10;
                                pdDet.setProgress(p);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        pdDet.dismiss();
                    }
                }.start();
            }

        });

        /* 日期选择器 */
        Button btn_datepicker = (Button) findViewById(R.id.btn_datepicker);
        btn_datepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取日历对象
                Calendar calendar = Calendar.getInstance();

                // 实例化日期选择器对话框
                new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String res = "您选择的是 ";
                        res += year + " 年 ";
                        res += month + " 月 ";
                        res += dayOfMonth + " 日";
                        Toast.makeText(MainActivity.this, res, Toast.LENGTH_SHORT).show();
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        /* 时间选择器 */
        Button btn_timepicker = (Button) findViewById(R.id.btn_timepicker);
        btn_timepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取日历对象
                Calendar calendar = Calendar.getInstance();

                // 实例化时间选择器对话框
                new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String res = "您选择的是 ";
                        res += hourOfDay + " 时 ";
                        res += minute + " 分";
                        Toast.makeText(MainActivity.this, res, Toast.LENGTH_SHORT).show();
                    }
                }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show();
            }
        });
    }
}
