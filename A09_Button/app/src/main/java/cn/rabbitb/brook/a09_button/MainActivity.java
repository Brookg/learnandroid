package cn.rabbitb.brook.a09_button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnOne, btnTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnOne = (Button) this.findViewById(R.id.btnOne);
        this.btnTwo = (Button) this.findViewById(R.id.btnTwo);
        this.btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnOne.getText().toString() == "按钮可用") {
                    btnOne.setEnabled(false);
                    btnOne.setText("按钮不可用");
                } else {
                    btnOne.setEnabled(true);
                    btnOne.setText("按钮可用");
                }
            }
        });
    }
}
