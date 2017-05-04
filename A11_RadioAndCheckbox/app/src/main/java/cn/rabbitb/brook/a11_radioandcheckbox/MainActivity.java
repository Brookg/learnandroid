package cn.rabbitb.brook.a11_radioandcheckbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup sexGroup;
    private CheckBox[] fruits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sexGroup = (RadioGroup) this.findViewById(R.id.sexGroup);
        sexGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int id) {
                RadioButton sexRadio = (RadioButton) findViewById(id);
                Toast.makeText(getApplicationContext(), "您选择了 " + sexRadio.getText(), Toast.LENGTH_LONG).show();
            }
        });

        Button btnSexPost = (Button) this.findViewById(R.id.btnSexPost);
        btnSexPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton sexRadio;
                for(int i = 0; i < sexGroup.getChildCount(); i++) {
                    sexRadio = (RadioButton) sexGroup.getChildAt(i);
                    if(sexRadio.isChecked()) {
                        Toast.makeText(getApplicationContext(), "提交 -- " + sexRadio.getText(), Toast.LENGTH_LONG).show();
                        break;
                    }
                }
            }
        });

        fruits = new CheckBox[4];
        fruits[0] = (CheckBox) findViewById(R.id.cb_apple);
        fruits[1] = (CheckBox) findViewById(R.id.cb_banana);
        fruits[2] = (CheckBox) findViewById(R.id.cb_pear);
        fruits[3] = (CheckBox) findViewById(R.id.cb_watermelon);

        for(int i = 0; i < fruits.length; i++) {
            fruits[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
                @Override
                public void onCheckedChanged(CompoundButton cbBtn, boolean b) {
                    String result = "";
                    for(int i = 0; i < fruits.length; i++) {
                        if(fruits[i].isChecked()) {
                            result = result + fruits[i].getText() + ", ";
                        }
                    }
                    if(result.length() > 2) {
                        result = result.substring(0, result.length() - 2);
                    } else {
                        result = "您什么也没有选中";
                    }
                    Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
