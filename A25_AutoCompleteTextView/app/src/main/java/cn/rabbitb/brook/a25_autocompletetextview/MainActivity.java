package cn.rabbitb.brook.a25_autocompletetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        MultiAutoCompleteTextView mactv = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView);

        String[] tips = new String[] {
                "小猫", "小狗", "小猪", "小兔", "小虎", "小蛇", "小熊"
        };

        ArrayAdapter<String> autoCompleteAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, tips);
        actv.setAdapter(autoCompleteAdapter);

        ArrayAdapter<String> multiAutoCompleteAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, tips);
        mactv.setAdapter(multiAutoCompleteAdapter);
        mactv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
