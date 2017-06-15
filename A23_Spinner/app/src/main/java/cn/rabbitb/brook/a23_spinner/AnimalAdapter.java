package cn.rabbitb.brook.a23_spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;


public class AnimalAdapter extends BaseAdapter {
    /*
        基础属性有两个：
        LinkedList<> dataList;    // 存放元素的列表
        Context context;    // 初始化时外部传入的上下文变量
     */
    private LinkedList<Animal> dataList;
    private Context context;

    // ViewHolder : 存放视图元素，避免每调用一次 getView 就重新获取一次
    ViewHolder viewHolder;

    // 构造函数
    public AnimalAdapter(LinkedList<Animal> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
        this.viewHolder = new ViewHolder();
    }

    // 自动生成的需要重写的函数
    @Override
    public int getCount() {
        return dataList == null ? 0 : dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            // 1. 若传入的View为空，则调用以下方法初始化它，下一次再传入的View是本次修改过的View
            view = LayoutInflater.from(context).inflate(R.layout.spinner_animals, viewGroup, false);

            // 2. 获取View中的相应元素
            viewHolder.icon = (ImageView) view.findViewById(R.id.icon);
            viewHolder.name = (TextView) view.findViewById(R.id.name);
        }

        // 3. 设置View中相应元素的相应属性
        viewHolder.icon.setBackgroundResource(dataList.get(i).getIcon());
        viewHolder.name.setText(dataList.get(i).getName());

        // 4. 返回的是传入的View参数
        return view;
    }

    private class ViewHolder {
        ImageView icon;
        TextView name;
    }
}
