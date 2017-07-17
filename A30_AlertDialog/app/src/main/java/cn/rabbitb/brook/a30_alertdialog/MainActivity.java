package cn.rabbitb.brook.a30_alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean[] checkedAnimals;
    private AlertDialog customizedAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* 普通的Dialog */
        Button btn_normal = (Button) findViewById(R.id.btn_normal);
        btn_normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建AlertDialog.Builder并设置属性
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("系统提示")
                        .setMessage("这是一个最普通的AlertDialog，\n有3个按钮，分别是取消、中立和确定")
                        .setCancelable(false)
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "你点击了取消按钮", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("中立", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "你点击了中立按钮", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "你点击了确定按钮", Toast.LENGTH_SHORT).show();
                            }
                        });
                // 创建AlertDialog并显示
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        /* 带列表的Dialog */
        Button btn_list = (Button) findViewById(R.id.btn_list);
        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 准备选项
                final String[] lessons = new String[] {"语文", "数学", "英语", "物理", "化学", "生物", "历史", "地理", "政治"};

                // 创建AlertDialog.Builder并设置属性
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("请选择您最喜欢的课程：")
                        .setItems(lessons, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "您选择了 " + lessons[which], Toast.LENGTH_SHORT).show();
                            }
                        });

                // 创建AlertDialog并显示
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        /* 带单选框的Dialog */
        Button btn_radio = (Button) findViewById(R.id.btn_radio);
        btn_radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 准备选项
                final String[] fruits = new String[] {"橘子", "苹果", "香蕉", "梨", "桃子", "西瓜"};

                // 创建AlertDialog.Builder并设置属性
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("请选择您最喜欢的水果：")
                        .setSingleChoiceItems(fruits, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "您选择了 " + fruits[which], Toast.LENGTH_SHORT).show();
                            }
                        });

                // 创建AlertDialog并显示
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        /* 带复选框的Dialog */
        Button btn_checkbox = (Button) findViewById(R.id.btn_checkbox);
        btn_checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 准备选项
                final String[] animals = new String[] {"狗", "猫", "兔子", "猴子", "老虎", "狮子"};
                checkedAnimals = new boolean[animals.length];
                for(int i = 0; i < animals.length; i++) {
                    checkedAnimals[i] = false;
                }

                // 创建AlertDialog.Builder并设置属性
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.little_cat)
                        .setTitle("请选择您喜欢的动物：")
                        .setMultiChoiceItems(animals, checkedAnimals, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                checkedAnimals[which] = isChecked;
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String res = "您选择了";
                                for (int i = 0; i < checkedAnimals.length; i++) {
                                    if (checkedAnimals[i]) {
                                        res += " " + animals[i];    // 匿名内部类可以访问外部类方法中final修饰的局部变量
                                    }
                                }
                                Toast.makeText(MainActivity.this, res, Toast.LENGTH_SHORT).show();
                            }
                        });

                // 创建AlertDialog并显示
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        /* 完全自定义的Dialog */
        Button btn_customized = (Button) findViewById(R.id.btn_customized);
        // 创建AlertDialog.Builder并设置属性
        AlertDialog.Builder customized_builder = new AlertDialog.Builder(MainActivity.this);

        // 加载自定义View，同时对自定义View进行设置
        LayoutInflater customized_inflater = MainActivity.this.getLayoutInflater();
        View view = customized_inflater.inflate(R.layout.dialog_custom, null, false);
        customized_builder.setView(view);
        customized_builder.setCancelable(false);
        customizedAlert = customized_builder.create();

        view.findViewById(R.id.go_baidu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "访问百度", Toast.LENGTH_SHORT).show();
                customizedAlert.dismiss();
            }
        });

        view.findViewById(R.id.dialog_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击 关闭", Toast.LENGTH_SHORT).show();
                customizedAlert.dismiss();
            }
        });

        view.findViewById(R.id.dialog_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击 取消", Toast.LENGTH_SHORT).show();
                customizedAlert.dismiss();
            }
        });

        btn_customized.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customizedAlert.show();
            }
        });
    }
}
