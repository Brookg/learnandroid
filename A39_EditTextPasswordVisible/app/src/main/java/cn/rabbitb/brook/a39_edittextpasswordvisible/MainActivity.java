package cn.rabbitb.brook.a39_edittextpasswordvisible;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText password;
    private Button toggle;
    private boolean is_visible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        password = (EditText) findViewById(R.id.password);
        is_visible = false;
        toggle = (Button) findViewById(R.id.toggle);
        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (is_visible) {
                    is_visible = false;
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    toggle.setText("隐藏密码");
                } else {
                    is_visible = true;
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    toggle.setText("显示密码");
                }
            }
        });
    }
}
