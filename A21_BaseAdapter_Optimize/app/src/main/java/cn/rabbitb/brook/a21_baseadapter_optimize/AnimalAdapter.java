package cn.rabbitb.brook.a21_baseadapter_optimize;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;


public class AnimalAdapter extends BaseAdapter {
    private LinkedList<Animal> animals;
    private Context context;
    private static ViewHolder viewHolder;

    public AnimalAdapter(LinkedList<Animal> animals, Context context) {
        this.animals = animals;
        this.context = context;
    }

    @Override
    public int getCount() {
        return animals.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // !! convertView 是可供复用的
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.icon);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.speak = (TextView) convertView.findViewById(R.id.speak);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.icon.setBackgroundResource(animals.get(position).getIcon());
        viewHolder.name.setText(animals.get(position).getName());
        viewHolder.speak.setText(animals.get(position).getSpeak());

        return convertView;
    }

    private static class ViewHolder {
        ImageView icon;
        TextView name;
        TextView speak;
    }
}
