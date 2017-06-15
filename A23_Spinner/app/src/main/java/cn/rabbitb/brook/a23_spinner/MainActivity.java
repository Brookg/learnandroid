package cn.rabbitb.brook.a23_spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 数据准备
        LinkedList<Animal> animals = new LinkedList<>();
        animals.add(new Animal(R.drawable.monkey, "猴子"));
        animals.add(new Animal(R.drawable.panda, "熊猫"));
        animals.add(new Animal(R.drawable.rabbit, "兔子"));
        animals.add(new Animal(R.drawable.snake, "蛇"));
        animals.add(new Animal(R.drawable.spider, "蜘蛛"));

        // 获取视图
        Spinner spinnerDropdown = (Spinner) findViewById(R.id.spinner_dropdown);

        // 应用适配器
        AnimalAdapter animalAdapter = new AnimalAdapter(animals, MainActivity.this);
        spinnerDropdown.setAdapter(animalAdapter);
    }
}
