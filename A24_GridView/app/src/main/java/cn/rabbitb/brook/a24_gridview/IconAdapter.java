package cn.rabbitb.brook.a24_gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;


public class IconAdapter extends BaseAdapter {
    private LinkedList<Icon> dataList;
    private Context context;

    private ViewHolder viewHolder;

    public IconAdapter(LinkedList<Icon> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;

        this.viewHolder = new ViewHolder();
    }

    @Override
    public int getCount() {
        return dataList == null ? 0 : dataList.size();
    }

    @Override
    public Icon getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.icon_layout, parent, false);

            viewHolder.icon = (ImageView) convertView.findViewById(R.id.icon);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
        }

        viewHolder.icon.setImageResource(dataList.get(position).getIcon());
        viewHolder.name.setText(dataList.get(position).getName());

        return convertView;
    }

    private class ViewHolder {
        ImageView icon;
        TextView name;
    }
}
