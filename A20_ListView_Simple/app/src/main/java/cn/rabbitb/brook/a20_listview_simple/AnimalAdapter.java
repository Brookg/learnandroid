package cn.rabbitb.brook.a20_listview_simple;

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
        convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);

        ImageView icon = (ImageView) convertView.findViewById(R.id.icon);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView speak = (TextView) convertView.findViewById(R.id.speak);

        icon.setBackgroundResource(animals.get(position).getIcon());
        name.setText(animals.get(position).getName());
        speak.setText(animals.get(position).getSpeak());

        return convertView;
    }
}
