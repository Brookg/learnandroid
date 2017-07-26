package cn.rabbitb.brook.a35_drawerlayout_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuAdapter extends BaseAdapter {
    private ArrayList<Menu> menus;
    private Context context;
    private ViewHolder viewHolder;

    public MenuAdapter(ArrayList<Menu> menus, Context context) {
        this.menus = menus;
        this.context = context;
        this.viewHolder = new ViewHolder();
    }

    @Override
    public int getCount() {
        return menus == null ? 0 : menus.size();
    }

    @Override
    public Object getItem(int i) {
        return menus.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.menu_item, viewGroup, false);

            viewHolder.icon = (ImageView) view.findViewById(R.id.menu_icon);
            viewHolder.title = (TextView) view.findViewById(R.id.menu_title);
        }

        viewHolder.icon.setImageResource(menus.get(i).getIcon());
        viewHolder.title.setText(menus.get(i).getTitle());

        return view;
    }

    private class ViewHolder {
        ImageView icon;
        TextView title;
    }
}
