package cn.rabbitb.brook.a22_listview_dataupdate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        // !! convertView 是可供复用的
        ViewHolder viewHolder;
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

    // 添加元素
    public boolean add(Animal newAnimal) {
        if(animals == null) {
            animals = new LinkedList<>();
        }
        animals.add(newAnimal);
        notifyDataSetChanged();
        return true;
    }

    // 往特定位置添加元素
    public boolean add(int pos, Animal newAnimal) {
        if(animals == null) {
            animals = new LinkedList<>();
        }
        if(animals.size() < pos) {
//            animals.add(newAnimal);
            Toast.makeText(context, "数据数量不足，尚未达到5条，不能在第5条后插入", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            animals.add(pos, newAnimal);
        }
        notifyDataSetChanged();
        return true;
    }

    // 清空
    public void clear() {
        if(animals != null) {
            animals.clear();
        }
        notifyDataSetChanged();
    }

    private static class ViewHolder {
        ImageView icon;
        TextView name;
        TextView speak;
    }
}
