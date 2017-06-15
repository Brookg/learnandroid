package cn.rabbitb.brook.a24_gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinkedList<Icon> icons = new LinkedList<>();
        icons.add(new Icon(R.drawable.autumn, getString(R.string.autumn)));
        icons.add(new Icon(R.drawable.beach, getString(R.string.beach)));
        icons.add(new Icon(R.drawable.boat, getString(R.string.boat)));
        icons.add(new Icon(R.drawable.camping, getString(R.string.camping)));
        icons.add(new Icon(R.drawable.earth, getString(R.string.earth)));
        icons.add(new Icon(R.drawable.hunting, getString(R.string.hunting)));
        icons.add(new Icon(R.drawable.iceberg, getString(R.string.iceberg)));
        icons.add(new Icon(R.drawable.snowman, getString(R.string.snowman)));
        icons.add(new Icon(R.drawable.whale, getString(R.string.whale)));

        GridView gridIcon = (GridView) findViewById(R.id.grid_icon);

        IconAdapter iconAdapter = new IconAdapter(icons, MainActivity.this);
        gridIcon.setAdapter(iconAdapter);
    }
}
