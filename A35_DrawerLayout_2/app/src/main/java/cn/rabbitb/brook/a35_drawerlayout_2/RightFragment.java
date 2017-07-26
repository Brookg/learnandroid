package cn.rabbitb.brook.a35_drawerlayout_2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class RightFragment extends Fragment {
    private DrawerLayout drawerLayout;
    private FragmentManager fragmentManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_right, container, false);
        Button btn_1 = (Button) view.findViewById(R.id.fg_btn_1);
        Button btn_2 = (Button) view.findViewById(R.id.fg_btn_2);
        Button btn_3 = (Button) view.findViewById(R.id.fg_btn_3);
        fragmentManager = getActivity().getSupportFragmentManager();
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentFragment fragment = new ContentFragment();
                Bundle args = new Bundle();
                args.putString("text", getString(R.string.fg_btn_1));
                fragment.setArguments(args);
                fragmentManager.beginTransaction().replace(R.id.main_content, fragment).commit();
                drawerLayout.closeDrawer(Gravity.END);
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentFragment fragment = new ContentFragment();
                Bundle args = new Bundle();
                args.putString("text", getString(R.string.fg_btn_2));
                fragment.setArguments(args);
                fragmentManager.beginTransaction().replace(R.id.main_content, fragment).commit();
                drawerLayout.closeDrawer(Gravity.END);
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentFragment fragment = new ContentFragment();
                Bundle args = new Bundle();
                args.putString("text", getString(R.string.fg_btn_3));
                fragment.setArguments(args);
                fragmentManager.beginTransaction().replace(R.id.main_content, fragment).commit();
                drawerLayout.closeDrawer(Gravity.END);
            }
        });
        return view;
    }

    public void setDrawerLayout(DrawerLayout drawerLayout) {
        this.drawerLayout = drawerLayout;
    }
}
